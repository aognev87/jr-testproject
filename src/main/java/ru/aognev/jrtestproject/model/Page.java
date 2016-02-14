package ru.aognev.jrtestproject.model;


public class Page {
    private int page = 0;
    private String pageRequest = "1";
    private int rowsPerPage = 10;
    private int rowsPerPageRequest = 10;

    //User's data
    private int userId;
    private String name;
    private int age;
    private int isAdmin = 0;
    private String createdDate;

    //Search options
    private int checkedName = -1;
    private int checkedAge = -1;
    private int checkedAdmin = -1;

    //
    private int update = -1;
    private int delete = -1;

    public Page() {
    }

    public Page(int page) {
        this.page = page;
    }

    public Page(String pageRequest) {
        this.pageRequest = pageRequest;
    }

    public Page(int page, String pageRequest) {
        this.page = page;
        this.pageRequest = pageRequest;
    }

    public Page(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.age = user.getAge();
        this.isAdmin = user.getIsAdmin();
        this.createdDate = user.getCreatedDate();
    }

    public void setUserData(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.age = user.getAge();
        this.isAdmin = user.getIsAdmin();
        this.createdDate = user.getCreatedDate();
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPageRequest(String pageRequest) {
        this.pageRequest = pageRequest;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public void setRowsPerPageRequest(int rowsPerPageRequest) {

        int firstRowOnPage = (page - 1) * rowsPerPage;
        pageRequest = String.valueOf(firstRowOnPage / rowsPerPageRequest + 1);

        rowsPerPage = rowsPerPageRequest;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setCheckedName(int checkedName) {
        this.checkedName = checkedName;
    }

    public void setCheckedAge(int checkedAge) {
        this.checkedAge = checkedAge;
    }

    public void setCheckedAdmin(int checkedAdmin) {
        this.checkedAdmin = checkedAdmin;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public User getUser() {
        User user = new User();

        user.setUserId(userId);
        user.setName(name);
        user.setAge(age);
        user.setIsAdmin(isAdmin);
        user.setCreatedDate(createdDate);

        return user;
    }

    public int getPage() {
        return page;
    }

    public String getPageRequest() {
        return pageRequest;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public int getRowsPerPageRequest() {
        return rowsPerPageRequest;
    }


    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public int getAge() {
        return age;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public int getCheckedName() {
        return checkedName;
    }

    public int getCheckedAge() {
        return checkedAge;
    }

    public int getCheckedAdmin() {
        return checkedAdmin;
    }

    public int getUpdate() {
        return update;
    }

    public int getDelete() {
        return delete;
    }
}
