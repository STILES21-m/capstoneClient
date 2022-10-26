/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.domain.OkHttp;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.domain.AddressType;
import za.ac.cput.domain.ContactType;
import za.ac.cput.domain.Department;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.domain.EmployeeContact;
import za.ac.cput.domain.EmployeeDepartment;
import za.ac.cput.domain.EmployeeGender;
import za.ac.cput.domain.EmployeeLeave;
import za.ac.cput.domain.EmployeeRole;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Leaves;
import za.ac.cput.domain.Salary;
import za.ac.cput.domain.EmployeeSalary;
import za.ac.cput.domain.Role;

import za.ac.cput.factory.AddressTypeFactory;
import za.ac.cput.factory.ContactTypeFactory;
import za.ac.cput.factory.DepartmentFactory;
import za.ac.cput.factory.EmployeeAddressFactor;
import za.ac.cput.factory.EmployeeContactFactory;
import za.ac.cput.factory.EmployeeDepartmentFactory;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.EmployeeGenderFactory;
import za.ac.cput.factory.EmployeeLeaveFactory;
import za.ac.cput.factory.EmployeeRoleFactory;
import za.ac.cput.factory.EmployeeSalaryFactory;
import za.ac.cput.factory.GenderFactory;
import za.ac.cput.factory.LeaveFactory;
import za.ac.cput.factory.RoleFactory;
import za.ac.cput.factory.SalaryFactory;

/**
 *
 * @author methysmacbookpro32
 */
public class OkHttpClient {
    
      public static MediaType JSON=MediaType.get("application/json; charset=utf-8");
    static final okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
    
  
    public static String POSTREQUEST(String passUrl, String JsonObject) throws IOException {

        RequestBody requestBody = RequestBody.create(JSON, JsonObject);
        Request request = new Request.Builder().url(passUrl).post(requestBody).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }

    }
    
    public static String PUTREQUEST(String passUrl, String JsonObject) throws IOException {

        RequestBody requestBody = RequestBody.create(JSON, JsonObject);
        Request request = new Request.Builder().url(passUrl).put(requestBody).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }

    }
      public static String readREQUEST(String passUrl) throws IOException {

        Request request = new Request.Builder().url(passUrl).get().build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }

    }
         /*
     *Full Name: Mutamba Prince Bulambo 
     *
     *Student Number: 220177767
    */
    public static  void SAVEEMPLOYEE(String firstname,String middleName,String lastName) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/employee/save";
        Employee employee= EmployeeFactory.build(firstname, middleName, lastName);
        Gson gson=new  Gson();
        String JsonString =gson.toJson(employee);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }

  public  static List<Employee> getAllEmployeeRequest()
    {
          List<Employee> EmployeeList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/employee/getAll";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), Employee.class);
                EmployeeList.add(returnType);
//                System.out.println("List Of Employee::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return EmployeeList;
    }
 public static Employee findByEmployeeIdRequest(String id) throws IOException
   {
        
            String readUrl="http://localhost:8080/employee-management/employee/read/";
        
            String url = readUrl + id;

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Response response = client.newCall(request).execute();

          System.out.println( "findByEmployeeId :"+response.body().string());
            
            System.out.println(response.body().toString());
            
            JSONObject json= new JSONObject(response.body().string());
            Employee address=new Gson().fromJson(json.toString(), Employee.class);
            
            
        return address;
}
    
 public static void deleteEmployeeById(String id) //pass the url from the Controller class for delete
    {
        String deleteUrl="http://localhost:8080/employee-management/employee/deleteById/";
        String url = deleteUrl+id;
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute())
        {
            System.out.println(response);
        }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }


    }
    public static  void SAVEEMPLOYEE_Role(String firstname,String middleName,String lastName) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/Employee/Gender/save";
        Employee employee= EmployeeFactory.build(firstname, middleName, lastName);
        Gson gson=new  Gson();
        String JsonString =gson.toJson(employee);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }

 public  static List<Object> getAllEmployee_Role()
    {
        List<Object> objectList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/employee/getAll";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), Object.class);
                objectList.add(returnType);
                System.out.println("List Of Employee::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return objectList;
    }
 
 
 public  static List<Object> ReadByEmployeeId(String id)
    {
          List<Object> AddressTypeList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/AddressType/All";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), Object.class);
                AddressTypeList.add(returnType);
               System.out.println("List Of Employee::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return AddressTypeList;
    }
 public static void UpdateEMPLOYEEById(String id,String firstname,String middle,String last) throws IOException{
  
     String url="http://localhost:8080/employee-management/employee/update/"+id;
     Employee employee=EmployeeFactory.buildEmployee(Long.parseLong(id), firstname, middle, firstname);
     
     Gson gson=new  Gson(); 
     String JsonString =gson.toJson(employee);
     String repo=PUTREQUEST(url,JsonString);
     if(repo !=null){
        
            JOptionPane.showMessageDialog(null, "Update succeffuly");
            System.out.println("Update succeffuly ");
        }
        else{
              System.out.println(" Sorry could not Update ");
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
  }
/*
 ==============================================================================================
 AddressType
 
 ****ISSUES TO RESOLVE******
 ==============================================================================================
 */
 
   
    public static  void saveAddressType(String StreetName,String AreaName,String PostalCode, String city) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/AddressType/save";
           AddressType address= AddressTypeFactory.buildAddressType(StreetName, AreaName, PostalCode,city);
        Gson gson=new  Gson();
        String JsonString =gson.toJson(address);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }

  public  static List<AddressType> getAllAddressType()
    {
          List<AddressType> AddressTypeList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/AddressType/All";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), AddressType.class);
                AddressTypeList.add(returnType);
               System.out.println("List Of Employee::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return AddressTypeList;
    }
 public static AddressType findByAddressTypeID(String id) throws IOException
   {
     
            String readUrl="http://localhost:8080/employee-management/AddressType/read/";
        
            String url = readUrl + id;

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().toString());
            
            JSONObject json= new JSONObject(response.body().string());
            AddressType address=new Gson().fromJson(json.toString(), AddressType.class);
            

            System.out.println( "findByEmployeeId :"+ address.toString());
                
        return address;
}
    
 public static void deleteAddressTypeById(String id) //pass the url from the Controller class for delete
    {
        String deleteUrl="http://localhost:8080/employee-management/AddressType/deleteById/";
        String url = deleteUrl+id;
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute())
        {
            System.out.println(response.body().toString());
        }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }


    } 
   public static void UpdateAddressTypeById(String id,String streetname,String area, String code,String city) throws IOException{
  
     String url="http://localhost:8080/employee-management/AddressType/update/"+id;
     AddressType ADDRESS=AddressTypeFactory.buildAddressTypei(Long.parseLong(id), streetname, code, area, city);
     Gson gson=new  Gson(); 
     String JsonString =gson.toJson(ADDRESS);
     String repo=PUTREQUEST(url,JsonString);
     if(repo !=null){
        
            JOptionPane.showMessageDialog(null, "Update succeffuly");
            System.out.println("Update succeffuly ");
        }
        else{
              System.out.println(" Sorry could not Update ");
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
  } 
   
//=====================================================================================================================

 /*
 ==============================================================================================
 GenderType
 ******ISSUES TO RESOLVE****
 ==============================================================================================
 */
  public static  void saveGenderType(String genderType,String descrp) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/gender/save";
           Gender address= GenderFactory.GenderBuilder(genderType, descrp);
        Gson gson=new  Gson();
        String JsonString =gson.toJson(address);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
  public  static List<Gender> getAllGenderType()
    {
          List<Gender> genderList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/gender/All";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), Gender.class);
                genderList.add(returnType);
               System.out.println("List Of Employee::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return genderList;
    }
  
   public static void deleteGenderById(String id) //pass the url from the Controller class for delete
    {
        String deleteUrl="http://localhost:8080/employee-management/gender/deleteById/";
        String url = deleteUrl+id;
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute())
        {
            System.out.println(response.body().toString());
        }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }


    }
   
   public static void UpdateGenderById(String id,String name,String Description) throws IOException{
  
     String url="http://localhost:8080/employee-management/gender/update/"+id;
     Gender gender=new Gender.Builder().setGenderId(Long.parseLong(id)).setGenderType(name).setDescription(Description).Build();
     
     Gson gson=new  Gson(); 
     String JsonString =gson.toJson(gender);
     String repo=PUTREQUEST(url,JsonString);
     if(repo !=null){
        
            JOptionPane.showMessageDialog(null, "Update succeffuly");
            System.out.println("Update succeffuly ");
        }
        else{
              System.out.println(" Sorry could not Update ");
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
  }
    /*
 ==============================================================================================
 ContactType
 ******ISSUES TO RESOLVE****
 ==============================================================================================
 */
  public static  void saveContactType(String email,String phoneNumber) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/contactType/save";
           ContactType contactType= ContactTypeFactory.build(email, phoneNumber);
        Gson gson=new  Gson();
        String JsonString =gson.toJson(contactType);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
  
   public  static List<ContactType> getAllContactType()
    {
          List<ContactType> genderList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/contactType/getAll";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), ContactType.class);
                genderList.add(returnType);
               System.out.println("List Of Employee::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return genderList;
    }
    public static  void updateContact(Long id, String EMAIL,String PHONE) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/contactType/update/"+id;
        ContactType Conc= new ContactType.Builder().setContactId(id).setEmail(EMAIL).
                setPhoneNumber(PHONE).build();
                
        Gson gson=new  Gson();
        String JsonString =gson.toJson(Conc);
        String respo=PUTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "UPDATE succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not UPDATE");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
     public static void deleteContactById(String id) //pass the url from the Controller class for delete
    {
        String deleteUrl="http://localhost:8080/employee-management/contactType/deleteById/";
        String url = deleteUrl+id;
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute())
        {
            System.out.println(" Deleted SUccessfully"+response);
        }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }


    }
 
     /*
 ==============================================================================================
 Salary
 Finished******
 ==============================================================================================
 */
   
    public static  void saveSalary(String salary,String salaryDesc) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/salary/save";
        Salary salaryobj= SalaryFactory.build( salary, salaryDesc);
        Gson gson=new  Gson();
        String JsonString =gson.toJson(salaryobj);
        String respo=POSTREQUEST(Url,JsonString);
        
         String result= (respo)!=""&& (respo)!=null ? "Save succeffuly": "Sorry could not save";
         JOptionPane.showMessageDialog(null,result);
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
     public  static List<Salary> getAllSalary()
    {
          List<Salary> salaryList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/salary/getAll";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), Salary.class);
                salaryList.add(returnType);
               System.out.println("List Of Employee::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return salaryList;
    }
     
     public static void deleteSalaryById(String id) //pass the url from the Controller class for delete
    {
        String deleteUrl="http://localhost:8080/employee-management/salary/deleteById/";
        String url = deleteUrl+id;
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute())
        {
            System.out.println(response.body().toString());
        }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
    }

      public static  void updateSalary(Long id, String salary,String salaryDesc) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/salary/update/"+id;
        Salary salaryobj= new Salary.Builder().setSalaryId(id).setSalaryAmount(salary)
                .setSalaryDescription(salaryDesc).build();
        Gson gson=new  Gson();
        String JsonString =gson.toJson(salaryobj);
        String respo=PUTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "UPDATE succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not UPDATE");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
         /*
 ==============================================================================================
 Leave

 ==============================================================================================
 */
   
      public static  void saveLeave(String daysOfLeave) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/leaves/save";
        Leaves leaveobj= LeaveFactory.build( Long.parseLong(daysOfLeave));
        Gson gson=new  Gson();
        String JsonString =gson.toJson(leaveobj);
        String respo=POSTREQUEST(Url,JsonString);
      
        
        String result= (respo)!=null ? "Save succeffuly": "Sorry could not save";
        JOptionPane.showMessageDialog(null,result);
        
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
       public  static List<Leaves> getAllLeave()
    {
          List<Leaves> LeaveList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/leaves/all";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), Leaves.class);
                LeaveList.add(returnType);
               System.out.println("List Of Employee::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return LeaveList;
    }
       
       
         public static void deleteLeaveById(String id) //pass the url from the Controller class for delete
    {
        String deleteUrl="http://localhost:8080/employee-management/leaves/deleteById/"+id;
       
        Request request = new Request.Builder()
                .url(deleteUrl)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute())
        {
            System.out.println(response.body().toString());
        }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
    }
        public static  void updateLeave(Long id, Long daysOfLeave) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/leaves/update/"+id;
        Leaves salaryobj= new Leaves.Builder().setLeaveId(id).setDaysOfLeave(daysOfLeave)
                .build();
        Gson gson=new  Gson();
        String JsonString =gson.toJson(salaryobj);
        String respo=PUTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "UPDATE succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not UPDATE");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
               /*
 ===========================================================================================================
  Department

 ===========================================================================================================
 */
        public static  void saveDepartment(String depName, String depDesc) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/department/save";
        Department depobj= DepartmentFactory.build( depName,depDesc);
        Gson gson=new  Gson();
        String JsonString =gson.toJson(depobj);
        String respo=POSTREQUEST(Url,JsonString);
      
        
        String result= (respo)!=null ? "Save succeffuly": "Sorry could not save";
        JOptionPane.showMessageDialog(null,result);
        
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
        
           public  static List<Department> getAllDepartment()
    {
          List<Department> DepartmentList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/department/getAll";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), Department.class);
                DepartmentList.add(returnType);
               System.out.println("List Of Department::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return DepartmentList;
    }
           
           
          public static void deleteDepartmentById(String id) //pass the url from the Controller class for delete
    {
        String deleteUrl="http://localhost:8080/employee-management/department/deleteById/"+id;
       
        Request request = new Request.Builder()
                .url(deleteUrl)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute())
        {
            System.out.println(response.body().toString());
            
        }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
    }
        
           public static  void updateDepartment(String id, String depName, String depDesc) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/department/update/"+id;
        Department departmentobj= new Department.Builder().setDeptId(Long.parseLong(id)).setDeptName(depName).setDeptDesc(depDesc)
                .build();
        Gson gson=new  Gson();
        String JsonString =gson.toJson(departmentobj);
        String respo=PUTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "UPDATE succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not UPDATE");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
      
               /*
 ===========================================================================================================
  EmployeeSalary

 ===========================================================================================================
 */
            public static  void saveEmployeeSalary(String employeeID,String salaryID) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/employeeSalary/save";
         EmployeeSalary es= EmployeeSalaryFactory.build(Long.parseLong(employeeID), Long.parseLong(salaryID));
          
          
        Gson gson=new  Gson();
        String JsonString =gson.toJson(es);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
                   public  static List<EmployeeSalary> getAllEmployeeSalary()
    {
          List<EmployeeSalary> empSalary = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/employeeSalary/getAll";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), EmployeeSalary.class);
                empSalary.add(returnType);
               System.out.println("List Of Department::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return empSalary;
    }
           
    /*
   ===========================================================================================================
    EmployeeLeave

   ===========================================================================================================
   */
           
            public static  void saveEmployeeLeave(String employeeID,String leaveID) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/employeeLeave/save";
           EmployeeLeave es= EmployeeLeaveFactory.build(Long.parseLong(employeeID), Long.parseLong(leaveID));
          
          
        Gson gson=new  Gson();
        String JsonString =gson.toJson(es);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
            
                public  static List<EmployeeLeave> getAllEmployeeLeave()
    {
          List<EmployeeLeave> empSalary = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/employeeLeave/getAll";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), EmployeeLeave.class);
                empSalary.add(returnType);
               System.out.println("List Of Department::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return empSalary;
    }
               
                               /*
 ===========================================================================================================
  EmployeeGender
                ***isues to resolve*****
                HAVING ISSUES WITH THE SAVE METHOD
 ===========================================================================================================
 */
                     
            public static  void saveEmployeeGender(String employeeID,String GenderID) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/EmployeeGender/save";
           EmployeeGender es= EmployeeGenderFactory.EmployeeGenderBuilder(Long.parseLong(employeeID), Long.parseLong(GenderID));
          
          
        Gson gson=new  Gson();
        String JsonString =gson.toJson(es);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
                    
                public  static List<EmployeeGender> getAllEmployeeGender()
    {
          List<EmployeeGender> empSalary = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/EmployeeGender/All";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), EmployeeGender.class);
                empSalary.add(returnType);
               System.out.println("List Of Department::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return empSalary;
    }  
                 /*
   ===========================================================================================================
    EmployeeContact
                **********Issues to resolve--TEST CLASS TO SEE IF IT FUNCTIONAL******

   ===========================================================================================================
   */
                
                
            public static  void saveEmployeeContact(String employeeID,String contactID) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/employeeContact/save";
           EmployeeContact es= EmployeeContactFactory.build(Long.parseLong(employeeID), Long.parseLong(contactID));
          
          
        Gson gson=new  Gson();
        String JsonString =gson.toJson(es);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }         
         
                         
                public  static List<EmployeeContact> getAllEmployeeContactr()
    {
          List<EmployeeContact> empSalary = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/employeeContact/getAll";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), EmployeeContact.class);
                empSalary.add(returnType);
               System.out.println("List Of Department::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return empSalary;
    } 
                
                   /*
   ===========================================================================================================
    EmployeeDepartment

   ===========================================================================================================
   */
               
            public static  void saveEmployeeDepartment(String employeeID,String depID) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/employeeDepartment/save";
           EmployeeDepartment es= EmployeeDepartmentFactory.build(Long.parseLong(employeeID), Long.parseLong(depID));
          
          
        Gson gson=new  Gson();
        String JsonString =gson.toJson(es);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }         
         
          
                       public  static List<EmployeeDepartment> getAllEmployeeDepartment()
    {
          List<EmployeeDepartment> empSalary = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/employeeDepartment/getAll";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), EmployeeDepartment.class);
                empSalary.add(returnType);
               System.out.println("List Of Department::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return empSalary;
    }
                
                     /*
   ===========================================================================================================
    EmployeeAddress

   ===========================================================================================================
   */
    public static  void saveEMPLOYEEAddressType(String employeeID,String AddressId) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/EmployeeAddress/save";
           EmployeeAddress address= EmployeeAddressFactor.EmployeeAddressBuilder(Long.parseLong(employeeID), Long.parseLong(AddressId));
        Gson gson=new  Gson();
        String JsonString =gson.toJson(address);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
          public  static List<EmployeeAddress> getAllEMPLOYEEAddressType()
    {
          List<EmployeeAddress> AddressTypeList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/EmployeeAddress/All";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), EmployeeAddress.class);
                AddressTypeList.add(returnType);
               System.out.println("List Of EmployeeAddress::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return AddressTypeList;
    }             
                             /*
   ===========================================================================================================
   Role

   ===========================================================================================================
   */            
    
      public static  void saveRole(String roleName,String roleDesc) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/role/save";
        Role salaryobj= RoleFactory.build(roleName, roleDesc);
        Gson gson=new  Gson();
        String JsonString =gson.toJson(salaryobj);
        String respo=POSTREQUEST(Url,JsonString);
        
         String result= (respo)!=""&& (respo)!=null ? "Save succeffuly": "Sorry could not save";
         JOptionPane.showMessageDialog(null,result);
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
       
    
    }
      
         public  static List<Role> getAllRole()
    {
          List<Role> DepartmentList = new ArrayList<>();
        try {
            String URL = "http://localhost:8080/employee-management/role/all";

            Request request = new Request.Builder()
                    .url(URL)
                    .build();
            Response response = client.newCall(request).execute();

            String responseBod = response.body().string();
            

            JSONArray identities = new JSONArray(responseBod);


            for (int i =0; i<identities.length(); i++) {
                JSONObject identity = identities.getJSONObject(i);
                Gson g = new Gson();
                var returnType = g.fromJson(identity.toString(), Role.class);
                DepartmentList.add(returnType);
               System.out.println("List Of Department::"+returnType.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return DepartmentList;
    }
           
           public static void deleteRoleById(String id) //pass the url from the Controller class for delete
    {
        String deleteUrl="http://localhost:8080/employee-management/role/deleteById/"+id;
       
        Request request = new Request.Builder()
                .url(deleteUrl)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute())
        {
            System.out.println(response.body().toString());
            
        }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
    }
                  public static  void updateRole(String id, String depName, String depDesc) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/role/update/"+id;
        Role departmentobj= new Role.Builder().setRoleId(Long.parseLong(id)).setRoleName(depName).setRoleDesc(depDesc)
                .build();
        Gson gson=new  Gson();
        String JsonString =gson.toJson(departmentobj);
        String respo=PUTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "UPDATE succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not UPDATE");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }
                             /*
   ===========================================================================================================
  Employee  Role issue
    
   ===========================================================================================================
   */   
                  
      public static  void saveEmployeeRole(String employeeID,String depID) throws IOException{
    
       try{ String Url="http://localhost:8080/employee-management/employeeRole/save";
          EmployeeRole es= EmployeeRoleFactory.build(Long.parseLong(employeeID), Long.parseLong(depID));
          
          
        Gson gson=new  Gson();
        String JsonString =gson.toJson(es);
        String respo=POSTREQUEST(Url,JsonString);
        if(respo !=null){
        
            JOptionPane.showMessageDialog(null, "save succeffuly");
        }
        else{
        
             JOptionPane.showMessageDialog(null, " Sorry could not save");
        }
       }
       catch(Exception exception){
       
        System.out.println(exception.getMessage());
       }
    
    }         
         
       
    public static void main(String[] args) throws IOException {
   
      // OkHttpClient.saveEmployeeDepartment("4", "5");
     
     
//    OkHttpClient.getAllEmployeeContactr();
//    
//     OkHttpClient.saveEmployeeRole("3", "3");
       
    }
     
   
}
