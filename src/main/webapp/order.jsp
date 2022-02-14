<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700');

body{
  background: url('http://all4desktop.com/data_images/original/4236532-background-images.jpg');
  font-family: 'Roboto Condensed', sans-serif;
  color: #262626;
  margin: 5% 0;
}
.container{
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}
@media (min-width: 1200px)
{
  .container{
    max-width: 1140px;
  }
}
.d-flex{
  display: flex;
  flex-direction: row;
  background: #f6f6f6;
  border-radius: 0 0 5px 5px;
  padding: 25px;
}
.form1{
  flex: 4;
}
.Yorder{
  flex: 2;
}
.title{
  background: -webkit-gradient(linear, left top, right bottom, color-stop(0, #5195A8), color-stop(100, #70EAFF));
  background: -moz-linear-gradient(top left, #5195A8 0%, #70EAFF 100%);
  background: -ms-linear-gradient(top left, #5195A8 0%, #70EAFF 100%);
  background: -o-linear-gradient(top left, #5195A8 0%, #70EAFF 100%);
  background: linear-gradient(to bottom right, #5195A8 0%, #70EAFF 100%);
  border-radius:5px 5px 0 0 ;
  padding: 20px;
  color: #f6f6f6;
}
h2{
  margin: 0;
  padding-left: 15px; 
}
.required{
  color: red;
}
label, table{
  display: block;
  margin: 15px;
}
label>span{
  float: left;
  width: 25%;
  margin-top: 12px;
  padding-right: 10px;
}
input[type="text"], input[type="tel"], input[type="email"], select
{
  width: 70%;
  height: 30px;
  padding: 5px 10px;
  margin-bottom: 10px;
  border: 1px solid #dadada;
  color: #888;
}
select{
  width: 72%;
  height: 45px;
  padding: 5px 10px;
  margin-bottom: 10px;
}
.Yorder{
  margin-top: 15px;
  height: 600px;
  padding: 20px;
  border: 1px solid #dadada;
}
table{
  margin: 0;
  padding: 0;
}
th{
  border-bottom: 1px solid #dadada;
  padding: 10px 0;
}
tr>td:nth-child(1){
  text-align: left;
  color: #2d2d2a;
}
tr>td:nth-child(2){
  text-align: right;
  color: #52ad9c;
}
td{
  border-bottom: 1px solid #dadada;
  padding: 25px 25px 25px 0;
}

p{
  display: block;
  color: #888;
  margin: 0;
  padding-left: 25px;
}
.Yorder>div{
  padding: 15px 0; 
}

button{
  width: 100%;
  margin-top: 10px;
  padding: 10px;
  border: none;
  border-radius: 30px;
  background: #52ad9c;
  color: #fff;
  font-size: 15px;
  font-weight: bold;
}
button:hover{
  cursor: pointer;
  background: #428a7d;
}
</style>
<body>
<div class="container">
  <div class="title">
      <h2>Commander</h2>
  </div>
<div class="d-flex">
  <form   action="<%= request.getContextPath() %>/CommandeServlet" method="post">
    <div class="form1">
    <label>
      <span class="fname">Prenom  <span class="required">*</span></span>
      <input type="text" name="prenom">
    </label>
    <label>
      <span class="lname">Nom <span class="required">*</span></span>
      <input type="text" name="nom">
    </label>
   <label>
      <span>Addresse <span class="required">*</span></span>
      <input type="text" name="add"  required>
    </label>
    
    <label>
      <span>Ville<span class="required">*</span></span>
      <input type="text" name="ville"> 
    </label>
   
    
    <label>
      <span>Telephone <span class="required">*</span></span>
      <input type="tel" name="tel"> 
    </label>
    <label>
      <span>Email  <span class="required">*</span></span>
      <input type="email" name="email"> 
    </label>
 </div>
  <div class="Yorder">
    <table>
     <%@ page import="dao.RepasDao,dao.DaoFactory, model.Repas,java.util.*" %>
      <tr>
        <th colspan="2">Votre commande</th>
      </tr>
      <tr>
        <td>Plat </td>
        <td><c:out value="${repas.getTitre()}" /></td>
      </tr>
      
      <tr>
        <td>Description</td>
        <td><c:out value="${repas.getDescription()}" /></td>
      </tr>
      <tr>
        <td>Prix</td>
        <td><c:out value="${repas.getPrix()}" />	Dh</td>
      </tr>
      <tr>
        <td>Expédition</td>
        <td>Livraison gratuite</td>
      </tr>
    </table><br>
    <div>
      <input type="radio" name="dbt" value="dbt" checked> Direct Bank Transfer
    </div>
    <p>
        Effectuez votre paiement directement sur notre compte bancaire. Veuillez utiliser votre ID de commande comme référence de paiement. Votre commande ne sera pas expédiée tant que les fonds n'auront pas été crédités sur notre compte.
    </p>
    <div>
      <input type="radio" name="dbt" value="cd"> Paiement à la livraison
    </div>
    <div>
      <input type="radio" name="dbt" value="cd"> Paypal <span>
      <img src="https://www.logolynx.com/images/logolynx/c3/c36093ca9fb6c250f74d319550acac4d.jpeg" alt="" width="50">
      </span>
    </div>
    <button type="submit">Passer la commande</button>
  </div><!-- Yorder -->
   </form>
 </div>
</div>
</body>
</html>