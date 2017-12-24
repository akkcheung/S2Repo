<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Contact</h1>

        <form id="form" action="./saveContact.action">
        
        <input type="hidden" name="contact.id" value="${contact.id}">
        <table>
            <tr>
                <td>Name:</td>
                <td>
                	<input type="text" name="contact.name" id="name" value="${contact.name}">
				</td>
            </tr>
            <tr>
                <td>Email:</td>               
                <td>
                	<input type="text" name="contact.email" id="email" value="${contact.email}">
				</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>
                	<input type="text" name="contact.address" id="address" value="${contact.address}">
				</td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td>
                	<input type="text" name="contact.telephone" id="telephone" value="${contact.telephone}">
				</td>
            </tr>
            <tr>
                <td colspan="1" align="center"><input type="submit" value="Save"></td>            
                <td><button type="cancel" onclick="window.location='./';return false;">Cancel</button>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>