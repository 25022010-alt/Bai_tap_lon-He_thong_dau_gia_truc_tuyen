class BankAccount {
    // "final"để accountNumber chỉ đọc,không thể thay đổi.
    private final String accountNumber;
    //"private" chặn truy cập trực tiếp từ bên ngoài.
    private String ownerName;
    private double balance;
    //Contructor1: tạo sự tiện lợi ,nhanh gọn khi không có nhu cầu nạp tiền ngay
    //Truyền vào 2 thông tin
     public BankAccount(String accountNumber,String ownerName){
        // this.accountNumber chỉ đến thuộc tính accountNumber của chính đối tượng BankAccount đang được tạo ra
        //accountNumber(không this) chỉ đến giá trị mà người dùng truyền vào qua ngoặc đơn của hàm
        this.accountNumber=accountNumber;
        this.ownerName=ownerName;
        this.balance=0.0;
    }
    //contructor2:Cho phép thiết lập số dư ngay từ đầu ,kèm logic bảo vệ dữ liệu
    //Truyền vào 3 thông tin
    public BankAccount(String accountNumber, String ownerName, double initiaBalance){
        this(accountNumber,ownerName);
        if(initiaBalance<0){
            System.out.println("So du ban dau khong am");
            this.balance=0.0;
        }
        else{
            this.balance=initiaBalance;
        }
    }
    //void:Thực hiện hành động không cần trả lại bất kỳ kết quả nào
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("So tien nap phai khong am");
        }
    }
    public boolean withdraw(double amount){
        if (amount <=0){
            System.out.println("So tien rut phai lon hon 0");
            return false;
        }
        if (this.balance>=amount){
            this.balance-=amount;
            return true;
        }
        System.out.println("So du khong du de rut");
        return false;
    }

    public double getBalance(){
        return this.balance;
    }
}
class Change{
    public static void change(BankAccount b1,BankAccount b2,double pay){
        if (b1.withdraw(pay)==true){
            b2.deposit(pay);
        }
    }
}
public void main(String[] args){
    // new để tạo ra một đối tượng được lưu trữ trong bộ nhớ Heap
    BankAccount myaccount=new BankAccount("1234","ABC",100);
    BankAccount newaccount=new BankAccount("2345","CDE",200);
    System.out.println(myaccount.getBalance()+","+newaccount.getBalance());
    Change.change(myaccount,newaccount,50);
    System.out.println(myaccount.getBalance()+","+newaccount.getBalance());
}
