# Table of contents
 * [**Introduction**](#introduction)
 * [**Project**](#project)
    * [**Login**](#login)
    * [**Gestio**](#gestio)
    * [**Alta**](#alta)

# Introduction 

This is a project in which we have to design a web application related to a pharmacy with this application we are going to use Servlets, HTML, CSS, Java, JavaScript, Maven and Tomcat Server to create it. The instructions of what methods we have to use and its functions are as follows:

* [Entorns_ FrontEnd.pdf](https://github.com/SPiedra955/pharmacy/files/11657564/Entorns_.FrontEnd.pdf)
* [Entorns_ Backend.pdf](https://github.com/SPiedra955/pharmacy/files/11657566/Entorns_.Backend.pdf)
* [Entorns_ BBDD.pdf](https://github.com/SPiedra955/pharmacy/files/11657576/Entorns_.BBDD.pdf) (Check this file to create the database, important!)

# Project

In the current project we have three main pages that are ````Login.html````, ````Gestio.html````, ````Alta.html```` that I will explain in this section, the three pages work with Servlets and instances of the XMLHttpRequest object. The XMLHttpRequest object is used in JavaScript to make asynchronous HTTP requests to a server.
The __GET__ and __POST__ methods are two of the most common HTTP methods used to send requests to a server.

### Login

It is a page where the user accesses with his username and password, the user information is stored in the database, the user must be created previously.

__Login view__

![image](https://github.com/SPiedra955/pharmacy_/blob/master/img/login.png)

### Gestio

On this page the doctor can see all patients related to his or her user as well as the name of the medicine prescribed to a patient and the date until which he or she has to continue the medication.
In addition, there is a __Alta__ button which will be used to prescribe new medicines to other users or the same in a new page.

__Gestio View Doctor 1__

![image](https://github.com/SPiedra955/pharmacy_/blob/master/img/doctor1_view.png)

__Gestio View Doctor 2__

![image](https://github.com/SPiedra955/pharmacy_/blob/master/img/doctor2_view.png)

### Alta

This is the last web page, its functionality is to add an id for a xip to assign a patient by means of his e-mail and a medicine with date assigned by a doctor, once the fields are filled they are sent to the database and to check that they are inserted we go back to Gestio which will load the new inserted data.

__View Alta__

![image](https://github.com/SPiedra955/pharmacy_/blob/master/img/view_alta.png)

__Patients__

![image](https://github.com/SPiedra955/pharmacy_/blob/master/img/view_patients.png)

__Medicines__ 

![image](https://github.com/SPiedra955/pharmacy_/blob/master/img/view_medicines.png)

__Calendar__

![image](https://github.com/SPiedra955/pharmacy_/blob/master/img/calendar.png)

__New record__

![image](https://github.com/SPiedra955/pharmacy_/blob/master/img/new_record1.png)

__Back to Gestio__

![image](https://github.com/SPiedra955/pharmacy_/blob/master/img/new_record2.png)
