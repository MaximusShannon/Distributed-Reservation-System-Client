package models;

import models.User;

import java.io.Serializable;

public class Session implements Serializable {

  public static User userSession;

  public static void resetSession(){

      userSession = null;
  }

}
