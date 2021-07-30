package dept.domain;

public class Dept {

	private int deptno;
	private String dname;
	private String loc;

	public Dept(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public Dept() {
	}

	public int getDeptno() {
		return this.deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Dept) {
			Dept dept = (Dept)obj;
			if (this.deptno != dept.deptno) {
				return false;
			} else {
				if (!this.dname.equals(dept.dname)) {
					return false;
				} else {
					return this.loc.equals(dept.loc);
				}
			}
		}
		return false;
	}
}
