package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.IAdmindao;
import model.admin.Admin;
import model.user.Car;
import model.user.RentRecord;
import utils.JdbcUtil;
import utils.PreparedStatementParameter;
import utils.ResultSetHandler;

public class AdmindaoImpl implements IAdmindao  {

	
	@Override
	public Admin login(String username, String password) {
	
	String sql = "select * from T_USER  where  username=? and password=? and type=1";
	Admin  admin  = new Admin ();

	JdbcUtil.query(sql, new PreparedStatementParameter() {

		@Override
		public void setValues(PreparedStatement ps) {
			try {
				ps.setString(1, username);
				ps.setString(2, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}, new ResultSetHandler() {

		/*
		 * 处理结果集 封装成对象
		 */
		@Override
		public void handlerRS(ResultSet rs) {
				try {
				if (rs.next()) {
					admin.setId(rs.getInt("id"));					
					admin.setUsername(rs.getString("username"));
					admin.setSex(rs.getInt("sex"));
					admin.setAddr(rs.getString("addr"));
					admin.setType(rs.getInt("type"));
					admin.setIdnumber(rs.getString("id_number"));
					admin.setPassword(rs.getString("password"));
					admin.setTel(rs.getString("tel"));
				 }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		}
			});

	return admin;
}

	

	@Override
	public ArrayList<Car> queryAllCar() {
		
			ArrayList<Car> list=new ArrayList<Car>();
			String sql="select * "
                    +" from t_car c join t_brand b on c.brand_id=b.id "
                    +" join t_category y on c.category_id=y.id   "
                    +" order by c.id asc ";
			JdbcUtil.query(sql, new PreparedStatementParameter(){

				@Override
				public void setValues(PreparedStatement ps) {
								
				}
				
			},new ResultSetHandler(){

				@Override
				public void handlerRS(ResultSet rs) {
				try {
					while(rs.next()){
						Car car=new Car();
					car.setId(rs.getInt(1));
					car.setCarnumber(rs.getString(2));
					car.setModel(rs.getString(4));
					car.setColor(rs.getString(5));
					car.setBrand(rs.getString(13));
					car.setCategory(rs.getString(15));
					car.setComments(rs.getString(7));
					car.setPrice(rs.getDouble(8));
					car.setRent(rs.getDouble(9));
					car.setStatus(rs.getInt(10));
					car.setUseable(rs.getInt(11));
					list.add(car);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
					
				}});
			return list;
			
		}
	
	@Override
	public ArrayList<Car> queryByCarId(int id) {
		
			ArrayList<Car> list=new ArrayList<Car>();
			String sql= "select c.id,c.model,c.t_comments,b.name,y.name,"
			+ " c.rent,"
			+ " c.useable ,"
			+ " c.status, c.car_number,c.price,c.status"
			+ " from t_car c join t_brand b on c.brand_id=b.id "
			+ " join t_category y on c.category_id=y.id  "
			+ " where  c.id=?";
			JdbcUtil.query(sql, new PreparedStatementParameter(){

				@Override
				public void setValues(PreparedStatement ps) {
					try {
						ps.setInt(1, id);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
			},new ResultSetHandler(){

				@Override
				public void handlerRS(ResultSet rs) {
				try {
					while(rs.next()){
						Car car=new Car();
					car.setId(rs.getInt(1));
					car.setModel(rs.getString(2));
					car.setComments(rs.getString(3));
					car.setBrand(rs.getString(4));
					car.setCategory(rs.getString(5));
					car.setColor(rs.getString(6));
					car.setRent(rs.getDouble(7));
					car.setUseable(rs.getInt(8));
					car.setCarnumber(rs.getString(9));
					car.setPrice(rs.getDouble(10));
					car.setStatus(rs.getInt(11));
					list.add(car);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
					
				}});
			return list;
			
		}
	

	@Override
	public void addCar(Car car) {
		String sql= "insert into t_car values (t_car_id_seq.nextval,?,?,?,?,?,?,?,?,?,?) ";
		 JdbcUtil.updateAll(sql, new PreparedStatementParameter(){

			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setString(1, car.getCarnumber());
					ps.setInt(2, car.getBrandid());
					ps.setString(3, car.getModel());
					ps.setString(4, car.getColor());
					ps.setInt(5, car.getCategoryid());
					ps.setString(6, car.getComments());
					ps.setDouble(7, car.getPrice());
					ps.setDouble(8, car.getRent());
					ps.setInt(9, car.getStatus());
					ps.setInt(10,car.getUseable());
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}});
			
		
	}

	@Override
	public void updateCarRent(int carid, Double rent) {
		String sql="update t_car set rent=? where id=? and status=0 ";
		
		JdbcUtil.updateAll(sql, new PreparedStatementParameter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setDouble(1, rent);
					ps.setInt(2, carid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}

	@Override
	public void updateCarGrouding(int carid, int status) {
		String sql="update t_car set status=? where id=?";
		JdbcUtil.updateAll(sql, new PreparedStatementParameter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setInt(1, status);
					ps.setInt(2, carid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}

	@Override
	public ArrayList<RentRecord> queryAllRecord() {
		ArrayList <RentRecord> list=new ArrayList<RentRecord>();
		
		String sql="select r.id,c.id,c.model,u.id,u.username,"
				+ " c.rent,r.payment,c.t_comments,b.name,"
				+ " y.name,r.start_date,r.return_date "
				+ " from t_user u,t_car c,t_brand b,"
				+ " t_category y,t_record r "
				+ " where u.id=r.user_id and c.id=r.car_id "
				+ " and c.brand_id=b.id and y.id=c.category_id "
				+ " order by r.id asc";
		JdbcUtil.query(sql,new PreparedStatementParameter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				
				
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handlerRS(ResultSet rs) {
				try {
					while(rs.next()){
					RentRecord record=new RentRecord();
					record.setId(rs.getInt(1));
					record.setCarid(rs.getInt(2));
					record.setModel(rs.getString(3));
					record.setUserid(rs.getInt(4));
					record.setUsername(rs.getString(5));
					record.setRent(rs.getDouble(6));
					record.setPayment(rs.getDouble(7));
					record.setTcomments(rs.getString(8));
					record.setBrand(rs.getString(9));
					record.setCategory(rs.getString(10));
					record.setStartdate(rs.getDate(11));
					record.setReturndate(rs.getDate(12));
					list.add(record);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		return list;
	}

	@Override
	public ArrayList<RentRecord> queryRecordByUserId(int userid) {
		
		ArrayList <RentRecord> list=new ArrayList<RentRecord>();
	
		String sql="select r.id,c.id,c.model,u.id,u.username,"
				+ " c.rent,r.payment,c.t_comments,b.name,"
				+ " y.name,r.start_date,r.return_date "
				+ " from t_user u,t_car c,t_brand b,"
				+ " t_category y,t_record r "
				+ " where u.id=r.user_id and c.id=r.car_id "
				+ " and c.brand_id=b.id and y.id=c.category_id and u.id=? "
				+ " order by r.id asc";
		JdbcUtil.query(sql,new PreparedStatementParameter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setInt(1, userid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handlerRS(ResultSet rs) {
				try { 
					while(rs.next()){
					RentRecord record=new RentRecord();
					record.setId(rs.getInt(1));
					record.setCarid(rs.getInt(2));
					record.setModel(rs.getString(3));
					record.setUserid(rs.getInt(4));
					record.setUsername(rs.getString(5));
					record.setRent(rs.getDouble(6));
					record.setPayment(rs.getDouble(7));
					record.setTcomments(rs.getString(8));
					record.setBrand(rs.getString(9));
					record.setCategory(rs.getString(10));
					record.setStartdate(rs.getDate(11));
					record.setReturndate(rs.getDate(12));
					list.add(record);}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		return list;
	}

	@Override
	public ArrayList<RentRecord> queryRecordByCarId(int carid) {

		ArrayList <RentRecord> list=new ArrayList<RentRecord>();
		
		String sql="select r.id,c.id,c.model,u.id,u.username,"
				+ " c.rent,r.payment,c.t_comments,b.name,"
				+ " y.name,r.start_date,r.return_date "
				+ " from t_user u,t_car c,t_brand b,"
				+ " t_category y,t_record r "
				+ " where u.id=r.user_id and c.id=r.car_id "
				+ " and c.brand_id=b.id and y.id=c.category_id and c.id=? "
				+ " order by r.id asc";
		JdbcUtil.query(sql,new PreparedStatementParameter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setInt(1, carid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handlerRS(ResultSet rs) {
				try {
					while(rs.next()){
					RentRecord record=new RentRecord();
					record.setId(rs.getInt(1));
					record.setCarid(rs.getInt(2));
					record.setModel(rs.getString(3));
					record.setUserid(rs.getInt(4));
					record.setUsername(rs.getString(5));
					record.setRent(rs.getDouble(6));
					record.setPayment(rs.getDouble(7));
					record.setTcomments(rs.getString(8));
					record.setBrand(rs.getString(9));
					record.setCategory(rs.getString(10));
					record.setStartdate(rs.getDate(11));
					record.setReturndate(rs.getDate(12));
					list.add(record);}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		return list;
	}

}
