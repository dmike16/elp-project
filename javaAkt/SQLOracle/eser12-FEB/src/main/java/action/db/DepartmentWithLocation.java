package action.db;


public class DepartmentWithLocation extends Department{
	    public DepartmentWithLocation(){
			super();
		}
		public Location getLocation(){
			return dep;
		}
		public void setLocation(Location d){
			dep = d;
		}
		@Override
		public String toString(){
			return "Nome Dep: " + super.getName() + "\n"+
					"Location : " + getLocation();
		}
			
		private Location dep;

}
