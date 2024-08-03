package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.ModelException;
import model.Post;
import model.User;

public class MySQLPostDAO implements PostDAO {

	@Override
	public boolean save(Post post) throws ModelException {
		
		DBHandler db = new DBHandler();
		
		String sqlInsert = "INSERT INTO posts VALUES "
				+ " (DEFAULT, ?, CURDATE(), ?);";
		
		db.prepareStatement(sqlInsert);
		db.setString(1, post.getContent());
		db.setInt(2, post.getUser().getId());
		  
		return db.executeUpdate() > 0;
	}

	@Override
	public boolean update(Post post) throws ModelException {
		
		DBHandler db = new DBHandler();
		
		String sqlUpdate = "UPDATE posts "
						 + " SET content = ?,"
						 + " user_id = ?"
						 + " WHERE id = ?";
		
		db.prepareStatement(sqlUpdate);
		
		db.setString(1, post.getContent());
		db.setInt(2, post.getUser().getId());
		db.setInt(3, post.getId());
		
		return db.executeUpdate() > 0;
	}

	@Override
	public boolean delete(Post post) throws ModelException {
		DBHandler db = new DBHandler();
		
		String sqlDelete = " DELETE FROM posts "
		         + " WHERE id = ?;";

		db.prepareStatement(sqlDelete);		
		db.setInt(1, post.getId());
		
		return db.executeUpdate() > 0;
	}

	@Override
	public List<Post> listAll() throws ModelException {
	
		DBHandler db = new DBHandler();
		
		List<Post> posts = new ArrayList<Post>();
			
		// Declara uma instrução SQL
		String sqlQuery = " SELECT u.id AS user_id, p.*, "
				        + " p.post_date "
				        + " FROM users u "
				        + " INNER JOIN posts p "
				        + " ON u.id = p.user_id "
				        + " ORDER BY content";
		
		db.createStatement();
	
		db.executeQuery(sqlQuery);

		while (db.next()) {
			Post p = createPost(db);
			
			posts.add(p);
		}
		
		return posts;
	}

	@Override
	public Post findById(int id) throws ModelException {
		
		DBHandler db = new DBHandler();
				
		String sql = "SELECT * FROM posts WHERE id = ?;";
		
		db.prepareStatement(sql);
		db.setInt(1, id);
		db.executeQuery();
		
		Post p = null;
		while (db.next()) {
			p = createPost(db);
			break;
		}
		
		return p;
	}
	
	private Post createPost(DBHandler db) throws ModelException {
		Post p = new Post(db.getInt("id"));
		p.setContent(db.getString("content"));
		p.setPostDate(db.getDate("post_date"));
		
		UserDAO userDAO = DAOFactory.createDAO(UserDAO.class); 
		
		User user = userDAO.findById(db.getInt("user_id"));
		p.setUser(user);
		
		return p;
	}
}
