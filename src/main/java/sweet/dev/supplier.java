package sweet.dev;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;
import java.util.LinkedList;

public class supplier {

    private  String userName;
    private  String password;
    private  String birthDate;
    private String phoneNum;
    private String email;
    private String city;
    private String street;
    private String homeNum;
    private String role;
    private String shopName;
    private int epmloyeeNum;
    private boolean productCreated;
    private LinkedList<product> products;
    private LinkedList<Order> orders;
    private boolean validProductToAdd;
    private boolean operationSuccess;
    private boolean wrongOldPass;
    private boolean mismatchPass;

    public boolean isMismatchPass() {
        return mismatchPass;
    }

    public boolean isWrongOldPass() {
        return wrongOldPass;
    }

    public LinkedList<Order> getOrders() {
        return orders;
    }

    private static final Logger logger = Logger.getLogger(supplier.class.getName());
    private DiscountRule discountRule;
    private ProductManager productManager;
    private OrderManager orderManager;
    public supplier(String userName, String password, String phoneNum, String email, String city, String street, String homeNum, String role, String shopName, int epmloyeeNum) {

        this.userName = userName;
        this.password = password;
        this.phoneNum = phoneNum;
        this.email = email;
        this.city = city;
        this.street = street;
        this.homeNum = homeNum;
        this.role = role;
        this.shopName = shopName;
        this.epmloyeeNum = epmloyeeNum;
        this.discountRule=new DiscountRule(30,3);
        products=new LinkedList<>();
        orders=new LinkedList<>();
        this.productManager = new ProductManager(this.products);
        this.orderManager=new OrderManager(this);

    }

    public supplier() {
        products=new LinkedList<>();
        this.productManager = new ProductManager(this.products);
        this.orderManager = new OrderManager(this);

    }

    public OrderManager getOrderManager() {
        return orderManager;
    }


    public ProductManager getProductManager() {
        return productManager;
    }
    public LinkedList<product> getProducts() {
        return products;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHomeNum() {
        return homeNum;
    }

    public String getRole() {
        return role;
    }

    public String getShopName() {
        return shopName;
    }

    public int getEpmloyeeNum() {
        return epmloyeeNum;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
        operationSuccess=true;

    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        operationSuccess=true;

    }

    public void setEmail(String email) {
        this.email = email;
        operationSuccess=true;

    }

    public void setCity(String city) {
        this.city = city;
        operationSuccess=true;
    }

    public void setStreet(String street) {
        this.street = street;
        operationSuccess=true;

    }

    public void setHomeNum(String homeNum) {
        this.homeNum = homeNum;
        operationSuccess=true;

    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setEpmloyeeNum(int epmloyeeNum) {
        this.epmloyeeNum = epmloyeeNum;
        operationSuccess=true;

    }

    public boolean isProductCreated() {
        return productCreated;
    }

    public void setProductCreated(boolean productCreated) {
        this.productCreated = productCreated;
    }

    public void addProduct(product p) {
        products.add(p);
    }


    public boolean isValidProductToAdd() {
        return validProductToAdd;
    }

    public void setValidProductToAdd(boolean validProductToAdd) {
        this.validProductToAdd = validProductToAdd;
    }

    private void setOperationSuccess(boolean operationSuccess) {
        this.operationSuccess = operationSuccess;
    }

    public boolean isOperationSuccess() {
        return operationSuccess;
    }


    public void updatePassword(String oldPassword, String newPassword, String confirmPassword) {
        if (oldPassword.equals(getPassword())) {
            wrongOldPass = false;
            if (newPassword.equals(confirmPassword)) {
                mismatchPass = false;
                setPassword(newPassword);
                operationSuccess = true;
            } else
                mismatchPass = true;

        } else
            wrongOldPass = true;


    }

}

