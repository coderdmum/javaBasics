package com.coderm.basics.javaBasics.day03.project;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);


    public CustomerView(){
//        Customer customer = new Customer("����", '��', 23, "13212341234", "wt@gmail.com");
//        customerList.addCustomer(customer);
    }

    /**
     * ��ʾ���ͻ���Ϣ�������������ķ���
     *
     * @Description
     * @author shkstart
     * @date 2019��1��19������11:36:26
     */
    public void enterMainMenu() {


        boolean isFlag = true;
        while(isFlag){
            System.out.println("\n-----------------�ͻ���Ϣ�������-----------------\n");
            System.out.println("                   1 �� �� �� ��");
            System.out.println("                   2 �� �� �� ��");
            System.out.println("                   3 ɾ �� �� ��");
            System.out.println("                   4 �� �� �� ��");
            System.out.println("                   5 ��       ��\n");
            System.out.print("                   ��ѡ��(1-5)��");

            char menu = CMUtility.readMenuSelection();
            switch(menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
//				System.out.println("�˳�");

                    System.out.print("ȷ���Ƿ��˳�(Y/N)��");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;

                    }
//				break;
            }

        }

    }

    /**
     * ��ӿͻ��Ĳ���
     *
     * @Description
     * @author shkstart
     * @date 2019��1��19������11:35:35
     */
    private void addNewCustomer() {
//		System.out.println("��ӿͻ��Ĳ���");
        System.out.println("---------------------��ӿͻ�---------------------");
        System.out.print("������");
        String name = CMUtility.readString(10);
        System.out.print("�Ա�");
        char gender = CMUtility.readChar();
        System.out.print("���䣺");
        int age = CMUtility.readInt();
        System.out.print("�绰��");
        String phone = CMUtility.readString(13);
        System.out.print("���䣺");
        String email = CMUtility.readString(30);

        //���������ݷ�װ��������
        Customer customer = new Customer(name, gender, age, phone, email);

        boolean isSuccess = customerList.addCustomer(customer);
        if(isSuccess){
            System.out.println("---------------------������---------------------");
        }else{
            System.out.println("-------------------�ͻ�Ŀ¼���������ʧ��---------------");
        }
    }

    /**
     * �޸Ŀͻ��Ĳ���
     *
     * @Description
     * @author shkstart
     * @date 2019��1��19������11:35:35
     */
    private void modifyCustomer() {
//		System.out.println("�޸Ŀͻ��Ĳ���");

        System.out.println("---------------------�޸Ŀͻ�---------------------");
        Customer cust ;
        int number;
        for(;;){
            System.out.print("��ѡ����޸Ŀͻ����(-1�˳�)��");
            number = CMUtility.readInt();

            if(number == -1){
                return;
            }

            cust = customerList.getCustomer(number - 1);
            if(cust == null){
                System.out.println("�޷��ҵ�ָ���ͻ���");
            }else{//�ҵ�����Ӧ��ŵĿͻ�
                break;

            }

        }
        //�޸Ŀͻ���Ϣ
        System.out.print("����(" + cust.getName() + "):");
        String name = CMUtility.readString(10, cust.getName());
        System.out.print("�Ա�(" + cust.getGender() + "):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("����(" + cust.getAge() + "):");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("�绰(" + cust.getPhone() + "):");
        String phone = CMUtility.readString(13, cust.getPhone());
        System.out.print("����(" + cust.getEmail()+ "):");
        String email = CMUtility.readString(30, cust.getEmail());

        Customer newCust = new Customer(name, gender, age, phone, email);

        boolean isRepalaced = customerList.replaceCustomer(number - 1, newCust);
        if(isRepalaced){
            System.out.println("---------------------�޸����---------------------");
        }else{
            System.out.println("---------------------�޸�ʧ��---------------------");
        }
    }

    /**
     * ɾ���ͻ��Ĳ���
     *
     * @Description
     * @author shkstart
     * @date 2019��1��19������11:35:35
     */
    private void deleteCustomer() {
//		System.out.println("ɾ���ͻ��Ĳ���");
        System.out.println("---------------------ɾ���ͻ�---------------------");
        int number;
        for(;;){
            System.out.print("��ѡ���ɾ���ͻ����(-1�˳�)��");
            number = CMUtility.readInt();

            if(number == -1){
                return;
            }

            Customer customer = customerList.getCustomer(number - 1);
            if(customer == null){
                System.out.println("�޷��ҵ�ָ���ͻ���");
            }else{
                break;
            }
        }

        //�ҵ���ָ���Ŀͻ�
        System.out.print("ȷ���Ƿ�ɾ��(Y/N)��");
        char isDelete = CMUtility.readConfirmSelection();
        if(isDelete == 'Y'){
            boolean deleteSuccess = customerList.deleteCustomer(number - 1);
            if(deleteSuccess){
                System.out.println("---------------------ɾ�����---------------------");
            }else{
                System.out.println("---------------------ɾ��ʧ��---------------------");
            }
        }else{
            return;
        }
    }

    /**
     * ��ʾ�ͻ��б�Ĳ���
     *
     * @Description
     * @author shkstart
     * @date 2019��1��19������11:35:35
     */
    private void listAllCustomers() {
//		System.out.println("��ʾ�ͻ��б�Ĳ���");
        System.out.println("---------------------------�ͻ��б�---------------------------\n");

        int total = customerList.getTotal();
        if(total == 0){
            System.out.println("û�пͻ���¼��");

        }else{
            System.out.println("���\t����\t�Ա�\t����\t�绰\t\t����");
            Customer[] custs = customerList.getAllCustomers();
            for(int i = 0;i < custs.length;i++){
                Customer cust = custs[i];
                System.out.println((i + 1) + "\t" + cust.getName() +
                        "\t" + cust.getGender() + "\t" + cust.getAge() +
                        "\t" + cust.getPhone() + "\t" + cust.getEmail());
            }
        }


        System.out.println("-------------------------�ͻ��б����-------------------------");
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

}
