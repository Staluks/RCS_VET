import Fields.Fields_Registration;

import java.awt.*;

public class Registration extends Fields_Registration {

public void registrationWindow (){
//defining panelregistration window for registration form
    panelRegistration.setVisible(true);
    panelRegistration.setLayout(null);
    panelRegistration.setBackground(Color.LIGHT_GRAY);
    panelRegistration.add(back);

  //if user wants he can click back to return to the first window
  back.setBounds(10, 10, 90, 40);
//top heading
  panelRegistration.add(registration);

  registration.setBounds(220, 50, 300, 70);

  //adding and defining all the text elements in the form
  panelRegistration.add(clinicName);
  panelRegistration.add(regNumber);
  panelRegistration.add(adres);
  panelRegistration.add(email);
  panelRegistration.add(phone);
  panelRegistration.add(regaddress);
  panelRegistration.add(username);
  panelRegistration.add(password);
  panelRegistration.add(reppassword);

  clinicName.setBounds(50, 60, 200, 200);
  regNumber.setBounds(50, 105, 200, 200);
  adres.setBounds(50,150,200,200 );
  email.setBounds(50,195,200,200);
  phone.setBounds(50,240,200,200);
  regaddress.setBounds(50,285,200,200);
  username.setBounds(50,325,200,200);
  password.setBounds(50,370,200,200);
  reppassword.setBounds(50,415,200,200);

  //adding all the fields for user input in the form
  panelRegistration.add(clinicNameText);
  panelRegistration.add(regNumberText);
  panelRegistration.add(adresText);
  panelRegistration.add(emailText);
  panelRegistration.add(phoneText);
  panelRegistration.add(regaddressText);
  panelRegistration.add(usernameText);
  panelRegistration.add(passwordText);
  panelRegistration.add(reppasswordText);

  clinicNameText.setBounds(280,140,200,35);
  clinicNameText.setText("");
  regNumberText.setBounds(280,185,200,35);
  regNumberText.setText("");
  adresText.setBounds(280,230,200,35);
  adresText.setText("");
  emailText.setBounds(280,275,200,35);
  emailText.setText("");
  phoneText.setBounds(280,320,200,35);
  phoneText.setText("");
  regaddressText.setBounds(280,365,200,35);
  regaddressText.setText("");
  usernameText.setBounds(280,410,200,35);
  usernameText.setText("");
  passwordText.setBounds(280,455,200,35);
  passwordText.setText("");
  reppasswordText.setBounds(280,500,200,35);
  reppasswordText.setText("");

  //submit button for creating new account
  panelRegistration.add(submit);

  submit.setBounds(440,570,150,60);

  panelRegistration.add(warning);

  warning.setBounds(20,550, 300,50);




}

}
