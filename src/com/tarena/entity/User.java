package com.tarena.entity;

public class User {
    private int id;
    private String Username;
    private String Password;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return Username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        Username = username;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return Password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        Password = password;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", Username=" + Username + ", Password="
                + Password + "]";
    }
    public User(int id, String username, String password) {
        super();
        this.id = id;
        Username = username;
        Password = password;
    }
    public User(String username, String password) {
        super();
        Username = username;
        Password = password;
    }
    
}
