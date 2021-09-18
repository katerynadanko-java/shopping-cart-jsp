<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cart Create Center</title>
    <style>
        td, th {
            font-family: arial, sans-serif;
        }
    </style>
    <script type="text/javascript">
        function validate() {
            if (document.forms["cart"]["productId"].value == "") {
                alert("Please enter product id");
                document.forms["productId"]["productId"].focus();
                return false;
            }
            if (document.forms["cart"]["amount"].value == "") {
                alert("Please enter product amount");
                document.forms["amount"]["amount"].focus();
                return false;
            }
        }
    </script>
</head>
<body style="background-color: #FFFFE0;">
<div style="margin-top:50px; margin-left:250px; height:50px;"><h2>Cart <c:out
        value="${cart.id != null ? 'Update' : 'cartRegistration' }"/></h2></div>


<form:form method="POST" modelAttribute="cartDTO" action="/api/cart/home" name="cart">
    <table style="vertical-align: center; margin-left:20%;">
        <td>${cartDTO.name}</td>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>productId :</td>
            <td><form:input path="productId" id="productId"/></td>
        </tr>
        <tr>
            <td>amount :</td>
            <td><form:input path="amount" id="amount"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<c:out value="${cart.id != null ? 'Update' : 'Register' }" />"
                                   onclick="return validate();">&nbsp;&nbsp; <a href="/api/cart/list">Cart List</a>&nbsp;
                <c:if test="${cart.id ne null}"><b>|</b>&nbsp;<a href="/api/cart/registration">adding new Cart</a></c:if>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
