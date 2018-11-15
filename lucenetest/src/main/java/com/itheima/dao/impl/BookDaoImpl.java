package com.itheima.dao.impl;

import com.itheima.dao.IBookDao;
import com.itheima.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {
    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucene_db","root","root");
            String sql = "select * from book";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("bookname"));
                book.setPrice(rs.getFloat("price"));
                book.setPic(rs.getString("pic"));
                book.setBookDesc(rs.getString("bookdesc"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookList;
    }
}
