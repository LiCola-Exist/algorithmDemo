package DesignPattern.Proxy;

import java.sql.SQLException;

/**
 * Created by LiCola on 2018/5/2.
 */
public interface ApiException {

  void throwException() throws SQLException;
}
