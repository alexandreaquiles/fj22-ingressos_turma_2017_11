<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="ingresso" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ingresso:template>
    <jsp:body>
		<div class=" col-md-6 col-md-offset-3">

        <h3>Nova sessão para sala: ${sala.nome}</h3>

        <form action='/admin/sessao' method="post">
            <input type="hidden" name="id" value="${form.id}">
            <input type="hidden" name="salaId" value="${form.salaId}">

            <div class="form-group">
                <label for="horario">Horario:</label>
                <input id="horario" type="text" name="horario" class="form-control" value="${form.horario}">
                <form:errors path="sessaoForm.horario"  cssClass="text-danger" />
            </div>

            <div class="form-group">
                <label for="filme">Filme:</label>
                <select id="filme" name="filmeId" class="form-control">
                    <option value="">Selecione um Filme</option>
                    <c:forEach var="filme" items="${filmes}">
                        <option value="${filme.id}" ${filme.id.equals(form.filmeId)? "selected": ""}>${filme.nome}</option>
                    </c:forEach>
                </select>
                <form:errors path="sessaoForm.filmeId" cssClass="text-danger" />
            </div>


            <button type="submit" class="btn btn-primary">Gravar</button>
        </form>
        </div>
    </jsp:body>
</ingresso:template>