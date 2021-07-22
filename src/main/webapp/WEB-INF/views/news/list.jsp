<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%@ include file="../header.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1>Aktualności</h1>
                </div>
                <a href="/news/add"><input type="button" value="Dodaj"></a>
            </div>
        </div>
    </section>
    <section class="content">
        <div class="card">
            <div class="row">
                <div class="col-12">
                    <div class="user-block">
                    </div>
                    <c:forEach items="${news}" var="news">
                        <div class="post clearfix">
                            <div class="user-block"><span class="username">
                            <a href="#"><c:out value="${news.personNews}"/></a>
                        </span>
                                <span class="description">Data dodania: <c:out value="${news.dateAdd}"/></span>
                            </div>
                            <p><c:out value="${news.subject}"/></p>
                            <p><c:out value="${news.content}"/></p>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>

