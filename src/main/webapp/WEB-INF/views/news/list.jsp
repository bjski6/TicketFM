<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="content-wrapper"><!-- Content Header(Page header) -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6"><h1>Aktualności</h1></div>
                <div class="card-footer"><a href="/news/add" ><input type="button" value="Dodaj">
                </a>

                </div>
            </div><!-- /.container-fluid -->
    </section><!-- Main content -->
    <section class="content"><!-- Default box -->
        <div class="card">
            <div class="row">
                <div class="col-12">
                    <div class="user-block"></span>
                    </div>


                    <c:forEach items="${news}" var="news">
                        <div class="post clearfix">
                            <div class="user-block"><span class="username"><a
                                    href="#"><c:out value="${news.personNews}"/></a></span><span
                                    class="description">Data dodania: <c:out value="${news.dateString}"/></span>
                            </div>
                            <p><c:out value="${news.subject}"/></p>
                            <p><c:out value="${news.content}"/></p>
                        </div>


                    </c:forEach>


                </div>
    </section><!-- /.content -->
</div>


<%@ include file="../footer.jsp" %>
