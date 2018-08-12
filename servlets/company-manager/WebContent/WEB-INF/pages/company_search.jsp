<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
Search results:
<ul>
    <c:forEach var="company" items="${companies}">
        <li>${company.id}: ${company.name}</li>
    </c:forEach>
</ul>
</body>
</html>