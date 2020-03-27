package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.IUserdao;
import model.user.Car;
import model.user.RentRecord;
import model.user.User;
import utils.GetnetTime;
import utils.JdbcUtil;
import utils.PreparedStatementParameter;
import utils.ResultSetHandler;

public class UserdaoImpl implements IUserdao {

	/** 用户登录
	 */
	
	@Override
	public User login(String username, String password) {
		String sql = "select * from T_USER  where  username=? and password=?";
		User user = new User();

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
					while (rs.next()) {
					user.setId(rs.getInt(1));					
					user.setUsername(rs.getString("username"));
					user.setSex(rs.getInt("sex"));
					user.setAddr(rs.getString("addr"));
					user.setType(rs.getInt("type"));
					user.setIdnumber(rs.getString("id_number"));
					user.setPassword(rs.getString("password"));
					user.setTel(rs.getString("tel"));
					 }
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
				}
		);

		return user;
	}

	
	public int getUserByName(String name){
		    String sql = "select * from t_user where username = ?";
		    int count = 0;		
			Connection conn = JdbcUtil.getConn();
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, name);
				rs = pstm.executeQuery();
				while(rs.next()){
					count++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcUtil.close(conn, rs, pstm);
			}
			return count;
		}
		
	
	public int getUserByIdnumber(String idnumber){
	    String sql = "select * from t_user where id_number = ?";
	    int count = 0;		
		Connection conn = JdbcUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idnumber);
			rs = pstm.executeQuery();
			while(rs.next()){
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, rs, pstm);
		}
		return count;
	}
	
	/* 用户注册
	 */
	@Override
	public void registe(User user) {
		//Connection conn = JdbcUtil.getConn();
		String sql = "insert into t_user  values (T_USER_ID_SEQ.nextval,?,?,?,?,?,?,?)";
		//PreparedStatement ps=null;

		 JdbcUtil.updateAll(sql, new PreparedStatementParameter(){

			@Override
			public void setValues(PreparedStatement ps) {
				
				try {
					//ps = conn.prepareStatement(sql);
					ps.setString(1, user.getUsername());
					ps.setString(2, user.getPassword());
					ps.setInt(3, user.getSex());
					ps.setString(4, user.getIdnumber());
					ps.setString(5, user.getTel());
					ps.setString(6, user.getAddr());
					ps.setInt(7, user.getType());
					//ps.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
			}});		
}
	@Override
	//new PreparedStatementParameter(){},new ResultSetHandler(){}
	public ArrayList<Car> queryAllCar() {
		ArrayList<Car> list=new ArrayList<Car>();
		String sql="select c.id,c.model,c.t_comments,b.name,y.name,c.color,"
				+ " c.rent,c.useable ,"
				+ " c.price,c.status  ,c.car_number "
				+ " from t_car c join t_brand b on c.brand_id=b.id "
				+ " join t_category y on c.category_id=y.id  " 
				+ " where c.useable=0 and c.status=0 order by c.id asc"; 
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
				car.setModel(rs.getString(2));
				car.setComments(rs.getString(3));
				car.setBrand(rs.getString(4));
				car.setCategory(rs.getString(5));
				car.setColor(rs.getString(6));
				car.setRent(rs.getDouble(7));
				car.setUseable(rs.getInt(8));
				car.setPrice(rs.getDouble(9));
				car.setStatus(rs.getInt(10));
				car.setCarnumber(rs.getString(11));
				list.add(car);}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			}});
		return list;
		
	}
	@Override
	public ArrayList<Car> queryByRentAsc() {
		ArrayList<Car> list=new ArrayList<Car>();
		String sql="select c.id,c.model,c.t_comments,b.name,y.name,c.color,"
				+ " c.rent, c.useable ,c.price,c.status,c.car_number"
				+ " from t_car c join t_brand b on c.brand_id=b.id "
				+ " join t_category y on c.category_id=y.id  " 
				+ " where c.useable=0 and c.status=0  order by c.rent asc "; 
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
				car.setModel(rs.getString(2));
				car.setComments(rs.getString(3));
				car.setBrand(rs.getString(4));
				car.setCategory(rs.getString(5));
				car.setColor(rs.getString(6));
				car.setRent(rs.getDouble(7));
				car.setUseable(rs.getInt(8));
				car.setPrice(rs.getDouble(9));
				car.setStatus(rs.getInt(10));
				car.setCarnumber(rs.getString(11));
				list.add(car);
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			}});
		return list;
		
	}
	
	
	@Override
	public ArrayList<Car> queryByRentDesc() {
		ArrayList<Car> list=new ArrayList<Car>();
		String sql="select c.id,c.model,c.t_comments,b.name,y.name,c.color,"
				+ " c.rent, c.useable ,c.price,c.status,c.car_number  " 
				+ " from t_car c join t_brand b on c.brand_id=b.id "
				+ " join t_category y on c.category_id=y.id  " 
				+ " where c.useable=0 and c.status=0  order by c.rent desc "; 
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
				car.setModel(rs.getString(2));
				car.setComments(rs.getString(3));
				car.setBrand(rs.getString(4));
				car.setCategory(rs.getString(5));
				car.setColor(rs.getString(6));
				car.setRent(rs.getDouble(7));
				car.setUseable(rs.getInt(8));
				car.setPrice(rs.getDouble(9));
				car.setStatus(rs.getInt(10));
				car.setCarnumber(rs.getString(11));
				list.add(car);
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			}});
		return list;
		
	}




	@Override
	public ArrayList<Car> queryByModel(String model) {
		ArrayList<Car> list=new ArrayList<Car>();
		String sql="select c.id,c.model,c.t_comments,b.name,y.name,c.color,"
				+ "c.rent, c.useable ,c.price,c.status,c.car_number " + 
				  " from t_car c join t_brand b on c.brand_id=b.id "
				+ " join t_category y on c.category_id=y.id  " 
				+ " where c.useable=0 and c.status=0 and c.model=? order by c.id asc "; 
		JdbcUtil.query(sql, new PreparedStatementParameter(){

			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setString(1, model);
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
				car.setPrice(rs.getDouble(9));
				car.setStatus(rs.getInt(10));
				car.setCarnumber(rs.getString(11));
				list.add(car);
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			}});
		return list;
		
	}

	@Override
	public ArrayList<Car> queryByCategory(String category) {
		ArrayList<Car> list=new ArrayList<Car>();
		String sql="select c.id,c.model,c.t_comments,b.name,y.name,c.color,"
				+ " c.rent, c.useable ,c.price,c.status,c.car_number" 
				+ " from t_car c join t_brand b on c.brand_id=b.id "
				+ " join t_category y on c.category_id=y.id  " 
				+ " where c.useable=0 and c.status=0 and y.name=? order by c.id asc "; 
		JdbcUtil.query(sql, new PreparedStatementParameter(){

			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setString(1, category);
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
				car.setPrice(rs.getDouble(9));
				car.setStatus(rs.getInt(10));
				car.setCarnumber(rs.getString(11));
				list.add(car);
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			}});
		return list;
	}

	@Override
	public ArrayList<Car> queryByBrand(String brand) {
		ArrayList<Car> list=new ArrayList<Car>();
		String sql= "select c.id,c.model,c.t_comments,b.name,y.name,c.color,"
				+ " c.rent, c.useable ,c.price,c.status,c.car_number" 
				+ " from t_car c join t_brand b on c.brand_id=b.id "
				+ " join t_category y on c.category_id=y.id  " 
				+ " where c.useable=0 and c.status=0 and b.name=? order by c.id asc "; 
		JdbcUtil.query(sql, new PreparedStatementParameter(){

			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setString(1, brand);
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
				car.setPrice(rs.getDouble(9));
				car.setStatus(rs.getInt(10));
				car.setCarnumber(rs.getString(11));
				list.add(car);
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			}});
		return list;
	}

	@Override
	public ArrayList<RentRecord> queryRecord(User user) {
		ArrayList <RentRecord> list=new ArrayList<RentRecord>();
		int id = user.getId();
		String sql="select r.id,c.id,c.model,u.id,u.username,"
				+ " c.rent,r.payment,c.t_comments,b.name,"
				+ " y.name,r.start_date,r.return_date "
				+ " from t_user u,t_car c,t_brand b,"
				+ " t_category y,t_record r "
				+ " where u.id=r.user_id and c.id=r.car_id "
				+ " and c.brand_id=b.id and y.id=c.category_id and u.id=?"
				+ " order by r.id asc";
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
	public ArrayList<RentRecord> queryRecord(Integer userid, Integer carid) {


		ArrayList <RentRecord> list=new ArrayList<RentRecord>();
				String sql="select r.id,c.id,c.model,u.id,u.username,"
				+ " c.rent,r.payment,c.t_comments,b.name,"
				+ " y.name,r.start_date,r.return_date "
				+ " from t_user u,t_car c,t_brand b,"
				+ " t_category y,t_record r "
				+ " where u.id=r.user_id and c.id=r.car_id "
				+ " and c.brand_id=b.id and y.id=c.category_id and u.id=? and c.id=?"
				+ " order by r.id asc";
		JdbcUtil.query(sql, new PreparedStatementParameter(){

			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setInt(1, userid);
					ps.setInt(2, carid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		},new ResultSetHandler(){

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
	public RentRecord queryRecordByRecordId(Integer userid, Integer recordid) {

	RentRecord record=new RentRecord();
			String sql="select r.id,c.id,c.model,u.id,u.username,"
			+ " c.rent,r.payment,c.t_comments,b.name,"
			+ " y.name,r.start_date,r.return_date "
			+ " from t_user u,t_car c,t_brand b,"
			+ " t_category y,t_record r "
			+ " where u.id=r.user_id and c.id=r.car_id "
			+ " and c.brand_id=b.id and y.id=c.category_id and u.id=? and r.id=?"
			+ " order by r.id asc";
	JdbcUtil.query(sql, new PreparedStatementParameter(){

		@Override
		public void setValues(PreparedStatement ps) {
			try {
				ps.setInt(1, userid);
				ps.setInt(2, recordid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	},new ResultSetHandler(){

		@Override
		public void handlerRS(ResultSet rs) {
			try {
				while(rs.next()){
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
				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	});
	return record;
}
	
	
	
	

	@Override
	public void RentCar(int userid,int carid) {
	String sql= "insert into t_record values (t_record_id_seq.nextval,?,?,to_date(to_char(sysdate,'yyyy-MM-dd'),'yyyy-MM-dd'),'','') ";
	String sql1="update t_car set status=1  where id=? ";
	JdbcUtil.updateAll(sql, new PreparedStatementParameter(){

		@Override
		public void setValues(PreparedStatement ps) {
			try {
				ps.setInt(1,userid);
				ps.setInt(2, carid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}});
	JdbcUtil.updateAll(sql1, new PreparedStatementParameter(){

		@Override
		public void setValues(PreparedStatement ps) {
			try {
				
				ps.setInt(1, carid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}});


	}
	@Override
	
	public void returnCar(int userid, int recordid ,int carid) {
		RentRecord record=new RentRecord();
		String sql="update  t_record  set"
				+ " return_date ="
				+ " to_date(to_char(sysdate,'yyyy-MM-dd'),'yyyy-MM-dd') ,"
				+ " payment=?"
				+ " where  user_id=? and id=? ";
		String sql1="update t_car set status=0  where id=? ";
		String sql2="select r.id,c.id,c.model,u.id,u.username,"
				+ " c.rent,r.payment,c.t_comments,b.name,"
				+ " y.name,r.start_date,r.return_date "
				+ " from t_user u,t_car c,t_brand b,"
				+ " t_category y,t_record r "
				+ " where u.id=r.user_id and c.id=r.car_id "
				+ " and c.brand_id=b.id and y.id=c.category_id and u.id=?"
				+ " order by r.id asc";
		JdbcUtil.query(sql2, new PreparedStatementParameter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setInt(1, userid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		},new ResultSetHandler() {
			
			@Override
			public void handlerRS(ResultSet rs) {				
				try {
					while(rs.next()){
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
					
						}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		  JdbcUtil.updateAll(sql,new PreparedStatementParameter(){

			@Override
			public void setValues(PreparedStatement ps) {
			try {
				//获取网络时间
				//GetnetTime.getNetworkTime().getTime()
				// new Date() 系统时间

				Double s=( new Date().getTime()-record.getStartdate().getTime()
					)/1000.00/60/60/24;
					System.out.println("天数:"+
					new Integer((int) Math.ceil(s))+"\n租金："+record.getRent());
				Double payment=Math.ceil(
				s)*record.getRent();			
				ps.setDouble(1, payment);
				ps.setInt(2, userid);
				ps.setInt(3, recordid);
				record.setPayment(payment);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			}});
		JdbcUtil.updateAll(sql1,new PreparedStatementParameter(){

			@Override
			public void setValues(PreparedStatement ps) {
			try {
				ps.setInt(1, carid);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			}});
		
	}
}
