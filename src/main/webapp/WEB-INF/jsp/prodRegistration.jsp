<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product Create Center</title>
    <style>
        td, th {
            font-family: arial, sans-serif;
        }
    </style>
    <script type="text/javascript">
        function validate() {
            if (document.forms["product"]["name"].value == "") {
                alert("Please enter product name");
                document.forms["product"]["name"].focus();
                return false;
            }
            if (document.forms["product"]["description"].value == "") {
                alert("Please enter description");
                document.forms["product"]["description"].focus();
                return false;
            }
            if (document.forms["product"]["price"].value == "") {
                alert("Please enter price");
                document.forms["product"]["price"].focus();
                return false;
            }
            // if (document.forms["product"]["amount"].value == "")  {
            //     alert("Please enter product amount");
            //     document.forms["product"]["amount"].focus();
            //     return false;
            // }
        }
    </script>
</head>
<body style="background-color: #FFFFE0;">
<div style="margin-top:50px; margin-left:250px; height:50px;"><h2>Product <c:out
        value="${product.id != null ? 'Update' : 'productRegistration' }"/></h2></div>


<form:form method="POST" modelAttribute="productDTO" action="/api/product/home" name="product">
    <table style="vertical-align: center; margin-left:20%;">
        <td>${productDTO.name}</td>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><form:input path="name" id="name"/></td>
        </tr>
        <tr>
            <td>Description :</td>
            <td><form:input path="description" id="description"/></td>
        </tr>
        <tr>
            <td>Price :</td>
            <td><form:input path="price" id="price"/></td>
        </tr>
<%--        <tr>--%>
<%--            <td>Amount :</td>--%>
<%--            <td><form:input path="amount" id="amount"/></td>--%>
<%--        </tr>--%>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="<c:out value="${product.id != null ? 'Update' : 'Register' }" />"
                                   onclick="return validate();">&nbsp;&nbsp; <a href="/api/product/list">Product List</a>&nbsp;
                <c:if test="${product.id ne null}"><b>|</b>&nbsp;<a href="/api/product/registration">adding new Product</a></c:if>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
