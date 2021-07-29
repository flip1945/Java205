package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.util.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;
import member.dto.Member;

public class MemberEditService {
	
	private MemberEditService() {}
	private static MemberEditService service = new MemberEditService();
	public static MemberEditService getInstance() {
		return service;
	}
	
	public void editMember(HttpServletRequest request) {
		int resultCnt = 0;

		Member member = new Member();

		Connection conn = null;
		MemberDao dao = null;
		
		File newFile = null;

		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);

			if (isMultipart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();

				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> itr = items.iterator();

				while (itr.hasNext()) {
					FileItem item = itr.next();
					String paramName = item.getFieldName();

					if (item.isFormField()) {
						if (paramName.equals("memberid")) {
							member.setMemberid(item.getString("utf-8"));
						} else if (paramName.equals("password")) {
							member.setPassword(item.getString("utf-8"));
						} else if (paramName.equals("membername")) {
							member.setMembername(item.getString("utf-8"));
						}

					} else {
						String uploadUri = "upload";
						String dir = request.getSession().getServletContext().getRealPath(uploadUri);

						File saveDir = new File(dir);

						if (!saveDir.exists()) {
							saveDir.mkdir();
						}

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

			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();

			resultCnt = dao.updateMember(conn, member);

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
