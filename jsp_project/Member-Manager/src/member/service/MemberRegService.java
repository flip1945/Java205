package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.util.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;
import member.dto.Member;

public class MemberRegService {

	private MemberRegService() {}
	private static MemberRegService service = new MemberRegService();
	public static MemberRegService getInstance() {
		return service;
	}

	public void regMember(HttpServletRequest request) throws FileUploadException {
		int resultCnt = 0;

		Member member = new Member();

		Connection conn = null;
		MemberDao dao = null;
		
		File newFile = null;

		try {
			// 1. Multipart 여부 확인
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);

			if (isMultipart) {
				// 2. 파일을 저장할 Factory 객체 생성
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// 3. 요청 처리를 (form 안에 있는 input들을 분리) 위해서 ServletFileUpload 생성
				ServletFileUpload upload = new ServletFileUpload(factory);

				// 4. 사용자 요청을 파싱(분리 : 원하는 형태로 분리 input => FileItem)
				// FileItem => input 데이터를 저장하고 있는 객체
				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> itr = items.iterator();

				while (itr.hasNext()) {
					FileItem item = itr.next();

					// file과 not file의 폼을 구분
					if (item.isFormField()) {
						// 회원 아이디, 회원 이름, 비밀번호
						String paramName = item.getFieldName();
						if (paramName.equals("memberid")) {
//							String value = item.getString();
							member.setMemberid(item.getString("utf-8"));
						} else if (paramName.equals("password")) {
							member.setPassword(item.getString("utf-8"));
						} else if (paramName.equals("membername")) {
							member.setMembername(item.getString("utf-8"));
						}

					} else {
						// 사진 데이터 처리
						String uploadUri = "upload";
						String dir = request.getSession().getServletContext().getRealPath(uploadUri);

						File saveDir = new File(dir);

						if (saveDir.exists()) {
							saveDir.mkdir();
						}

						String paramName = item.getFieldName();
						if (paramName.equals("photo")) {
							if (item.getName() != null && item.getSize() > 0) {
								newFile = new File(saveDir, item.getName());
								item.write(newFile);
								member.setMemberphoto(item.getName());
							}
						}
					}
				}
			} else {
				throw new Exception("multipart 타입이 아닙니다.");
			}

			// db Insert

			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();

			resultCnt = dao.insertMember(conn, member);

		} catch (SQLException e) {
			e.printStackTrace();
			if (newFile != null && newFile.exists()) {
				newFile.delete();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		request.setAttribute("result", resultCnt);
	}
}
