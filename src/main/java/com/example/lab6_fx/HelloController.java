package com.example.lab6_fx;

import com.example.lab6_fx.model.ClassContainer;
import com.example.lab6_fx.model.Group;
import com.example.lab6_fx.model.Student;
import com.example.lab6_fx.model.StudentCondition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private ObservableList<Group>group;
    private ObservableList<Student> student;
    ClassContainer classContainer=new ClassContainer();


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to student Application!");
    }
    @FXML
    private TableView<Group> Group_table;
    @FXML
    private TableView<Student> Student_table;
    //group
    @FXML
    private TableColumn<Group, String> GroupName;
    @FXML
    private TableColumn<Group, Integer> NoStudents;
    //student
    @FXML
    private TableColumn<Student, Integer> ID;
    @FXML
    private TableColumn<Student, String> LastName;
    @FXML
    private TableColumn<Student, String> Name;
    @FXML
    private TableColumn<Student, Double> NumberOfCredits;
    @FXML
    private TableColumn<Student, StudentCondition> Status;
    @FXML
    private TableColumn<Student, Integer> YearOfBirth;
    @FXML
    private ComboBox<?> changeStatus;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        group= FXCollections.observableArrayList();
        student=FXCollections.observableArrayList();
        Student_table.setEditable(true);
        initTables();
        loadTableData();
        events();
    }
    private void initTables(){
        //group
        GroupName.setCellValueFactory(new PropertyValueFactory<>("GroupName"));
      //NoStudents.setCellValueFactory(new PropertyValueFactory<>("NoStudents"));
        //students
        ID.setCellValueFactory(new PropertyValueFactory<Student, Integer>("ID"));
        ID.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Name.setCellFactory(TextFieldTableCell.forTableColumn());
        LastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        LastName.setCellFactory(TextFieldTableCell.forTableColumn());
        NumberOfCredits.setCellValueFactory(new PropertyValueFactory<Student, Double>("NumberOfCredits"));
        NumberOfCredits.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        //Status.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        YearOfBirth.setCellValueFactory(new PropertyValueFactory<Student, Integer>("YearOfBirth"));
        YearOfBirth.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }
    private void loadTableData(){


        for (int i = 0; i <classContainer.getGroupSize(); i++) {
           group.add(classContainer.getClassByID(i));
        }
        Group_table.setItems(group);

      Group_table.setOnMouseClicked(e->{
          events();
     });
    }

    private void events(){
        for (Group group: Group_table.getSelectionModel().getSelectedItems()){
            student.clear();
       for (int i = 0; i <classContainer.getClassByID(Group_table.getSelectionModel().getFocusedIndex()).StudentNum(); i++) {
          student.add(classContainer.getClassByID(Group_table.getSelectionModel().getFocusedIndex()).getStudentByID(i));
       }
        Student_table.setItems(student);

    }}
}