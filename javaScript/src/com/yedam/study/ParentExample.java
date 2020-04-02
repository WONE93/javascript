package com.yedam.study;

public class ParentExample {
   public static void main(String[] args) {
      Parent p = new Parent();
      p.name = "hong";
      showInfo(p);
      
//      Child c = new Child();
//      c.name = "Hwang";
//      c.age = 10;
      showInfo(new Parent() {
         int age;
         int getAge() {
            return age;
         }
         @Override
         String getName() {
            super.setName("Hwang");
            return super.getName();
         }
         
      });
      
      
      getEmp(new EmpService() {
         @Override
         public void getEmployee(int empId) {
            System.out.println("empId: " + empId);
         }
      });
      
//      EmpService empService = new EmpServiceImp();
//      getEmp(empService);
      
      
      //익명의 객체
      EmpService empService1 = new EmpService() {
         @Override
         public void getEmployee(int empId) {
            System.out.println("empId: " + empId);
         }
      };
      getEmp(empService1);
      
   }
   static void getEmp(EmpService emp) {
      emp.getEmployee(101);
   }
   static void showInfo(Parent p) {
      System.out.println(p.getName());
   }
}