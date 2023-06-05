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

![image](https://github.com/SPiedra955/pharmacy/assets/114516225/84bd966b-986a-47da-b914-747a88babe5c)

### Gestio

On this page the doctor can see all discharges related to his or her user as well as the name of the medicine prescribed to a patient and the date until which he or she has to continue the medication.
In addition, there is a __Alta__ button which will be used to prescribe new medicines to other users in a new page.

__Gestio View Doctor 1__

![image](https://github.com/SPiedra955/pharmacy/assets/114516225/ff76a46b-214e-4c09-8e63-c76cb68e98b8)

__Gestio View Doctor 2__

![image](https://github.com/SPiedra955/pharmacy/assets/114516225/2f1e8570-af44-4756-9c58-7c7d2a082912)

### Alta

This is the last web page, its functionality is to add an id for a xip to assign a patient by means of his e-mail and a medicine with date assigned by a doctor, once the fields are filled they are sent to the database and to check that they are inserted we go back to Gestio which will load the new inserted data.

__View Alta__

![image](https://github.com/SPiedra955/pharmacy/assets/114516225/a74f6cac-79d0-4ba5-9eac-2942b9e09213)

__Patients__

![image](https://github.com/SPiedra955/pharmacy/assets/114516225/242983e6-9447-4f9b-ab24-55dd4eab12c8)

__Medicines__ 

![image](https://github.com/SPiedra955/pharmacy/assets/114516225/fd4ad8b2-eb69-46d1-bfce-525e4aef4c65)

__Calendar__

![image](https://github.com/SPiedra955/pharmacy/assets/114516225/07f0decf-9bff-44dc-b3e1-73334c4270c2)

__Back to Gestio and new record__

![image](https://github.com/SPiedra955/pharmacy/assets/114516225/fda526ad-09e1-4336-950d-3caff6be5422)
