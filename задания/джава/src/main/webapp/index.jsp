<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="/main" method="post">
    <h3> Summer? </h3>
    <input name="summer" type="radio" value="yes"/>
    <input name="summer" type="radio" value="no"/>
    <h3> Morning? </h3>
    <input name="morning" type="radio" value="yes"/>
    <input name="morning" type="radio" value="no"/>
    <input type="submit"/>

</form>
${count}
</body>
</html>
