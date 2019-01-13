<%--
  Created by IntelliJ IDEA.
  User: Aaron
  Date: 2/11/2018
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Admin console</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12px;
        }
        h1 {
            text-align:center;
        }
        /*Table Elements*/
        td {
            vertical-align:top;
        }
        fieldset {
            text-align: left;
            padding: 5px;
            background-color: #eee;
        }
        legend {
            background-color: #f93;
            border: 1px solid #f00;
            padding: 5px;
            margin-bottom:5px;
        }
        section {
            width: 550px;
            margin: 20px auto;
        }
        /* Centers validation text */
        #validation {
            text-align:center;
        }
    </style>
</head>
<p>
    <a href="/newsfeed">Back to Homepage</a>
</p>
<header><h1>Admin Console</h1></header>
<form:form action="/dreamloud/addUser">
    <section>
        <fieldset>
            <legend>
                <strong>Add a user</strong>
            </legend>
            <h4>Please complete the following information about the user</h4>
            <table>
                <tr>
                    <td>First name:</td>
                    <td><input type="text" name="userFirstName" id="userFirstName" size="30" tabindex="1" placeholder="First Name" autofocus required></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><input type="text" name="userLastName" id="userLastName" size="30" tabindex="1" placeholder="Last Name" autofocus required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="userEmail" id="email" size="30" tabindex="2" placeholder="Email Address" required></td>
                </tr>
                <tr>
                    <td>User Pic:</td>
                    <td><input type="text" name="userPic" id="userPic" size="30" tabindex="3" placeholder="Link to user pic" required></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="userPass" id="userPass" size="30" tabindex="3" placeholder="User Password" required></td>
                </tr>
                <tr>
                    <td>User Bio:</td>
                    <td><textarea name="userBio" id="UserComments" cols="60" rows="7" tabindex="15" placeholder="Place user bio here" ></textarea></td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </fieldset>
    </section>
</form:form>
<form:form action="/dreamloud/addDream">
    <section>
        <fieldset>
            <legend>
                <strong>Add a Dream</strong>
            </legend>
            <h4>Please complete the following information about the dream</h4>
            <table>
                <tr>
                    <td>Dream name:</td>
                    <td><input type="text" name="dreamName" id="DreamName" size="30" tabindex="1" placeholder="Dream Name" autofocus required></td>
                </tr>
                <tr>
                    <td>Dream Bio:</td>
                    <td><textarea name="dreamBio" id="DrmComments" cols="60" rows="7" tabindex="15" placeholder="Place dream bio here" ></textarea></td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </fieldset>
    </section>
</form:form>
<form:form action="/dreamloud/removeUser">
    <section>
        <fieldset>
            <legend>
                <strong>Remove a user</strong>
            </legend>
            <h4>Please complete the following information about the user</h4>
            <table>
                <%--<tr>--%>
                    <%--<td>First name:</td>--%>
                    <%--<td><input type="text" name="userFirstName" size="30" tabindex="1" placeholder="First Name" autofocus></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>Last name:</td>--%>
                    <%--<td><input type="text" name="userLastName" size="30" tabindex="1" placeholder="Last Name" autofocus></td>--%>
                <%--</tr>--%>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="userEmail" size="30" tabindex="2" placeholder="Email Address" required></td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </fieldset>
    </section>
</form:form>
<form:form action="/dreamloud/removeDream">
    <section>
        <fieldset>
            <legend>
                <strong>Remove a Dream</strong>
            </legend>
            <h4>Please complete the following information about the dream</h4>
            <table>
                <tr>
                    <td>Dream name:</td>
                    <td><input type="text" name="dreamName" size="30" tabindex="1" placeholder="Dream Name" autofocus required></td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </fieldset>
    </section>
</form:form>
<footer>
    <p id="validation">
        <a href="http://validator.w3.org/check?uri=referer" title="HTML5 Validation">HTML5 Validation</a>
    </p>
</footer>

</body>
</html>
