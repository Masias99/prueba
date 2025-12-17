<%-- 
    Document   : index
    Created on : 23 nov. 2025, 10:28:02
    Author     : christianruiz
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/daisyui@5" rel="stylesheet" type="text/css" />
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
        <script src="https://unpkg.com/just-validate@latest/dist/just-validate.production.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <main class="mx-auto max-w-4xl shadow-xl rounded">
            <header class="flex justify-between m-4">
                <h2 class="text-2xl font-bold">Gestion de Estudiantes</h2>
                <button class="btn btn-primary" onclick="my_modal_1.showModal()">+ Nuevo Estudiante</button>
            </header>
            <div class="overflow-x-auto">
                <table class="table">
                    <!-- head -->
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Email</th>
                            <th>Carrera</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- row 1 -->
                        <%
                            List<Estudiante> estudiantes = (List<Estudiante>) request.getAttribute("listaEstudiantes");
                            if (estudiantes != null) {
                                for (Estudiante est : estudiantes) {

                        %>


                        <tr>
                            <th> <%= est.getId()%></th>
                            <td><%= est.getNombre()%></td>
                            <td><%= est.getEmail()%></td>
                            <td><%= est.getCarrera()%></td>
                            <td>
                                <button class="btn-edit hover:scale-125 text-gray-600 "
                                        data-id="<%= est.getId()%>"
                                        data-nombre="<%= est.getNombre()%>"
                                        data-email="<%= est.getEmail()%>"
                                        data-carrera="<%= est.getCarrera()%>"
                                        >
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-pen-icon lucide-pen"><path d="M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z"/></svg>
                                </button>
                                <a class="hover:scale-125 text-red-600" href="/HolaMundo/EstudianteDelete?id=<%= est.getId()%>"  >
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-trash2-icon lucide-trash-2"><path d="M10 11v6"/><path d="M14 11v6"/><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6"/><path d="M3 6h18"/><path d="M8 6V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"/></svg>
                                </a>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </main>

        <!-- Open the modal using ID.showModal() method -->
        <dialog id="my_modal_1" class="modal">
            <div class="modal-box">
                <h2 class="text-xl font-bold" id="titulomodal">Nuevo Estudiante</h2>
                <form id="formularioEstudiante" action="EstudianteServlet" method="post" autocomplete="off">
                    <label class="font-semibold mb-1">Nombre:</label>
                    <input class="input input-bordered w-full" type="text" name="nombre" id="nombre"/>
                    <br>
                    <label class="font-semibold mb-1">Email:</label>
                    <input class="input input-bordered w-full" type="email" name="email" id="email"/>
                    <br>
                    <label class="font-semibold mb-1">Carrera:</label>
                    <input class="input input-bordered w-full" type="text" name="carrera"id="carrera"/>
                    <br>
                    <div>
                        <button class="btn btn-ghost" onclick="my_modal_1.close()"> Cancelar</button>
                        <button class="btn btn-primary" type="submit" >Enviar</button>
                    </div>
                </form>
            </div>
        </dialog>
        <script>

            document.querySelectorAll(".btn-edit").forEach(btn => {
                btn.addEventListener("click", (e) => {
                    document.querySelector("#titulomodal").innerText = "Editar Estudiante";
                    console.log("abriendo el modal: " + e.currentTarget);
                    document.getElementById("nombre").value = e.currentTarget.dataset.nombre;
                    document.getElementById("email").value = e.currentTarget.dataset.email;
                    document.getElementById("carrera").value = e.currentTarget.dataset.carrera;
                    document.getElementById("formularioEstudiante").action = "EstudianteEditServlet?id=" + e.currentTarget.dataset.id;
                    my_modal_1.showModal();

                })
            })

        </script>
        <script>
            const validate = new JustValidate("#formularioEstudiante");

            validate
                    .addField('#nombre', [
                        {rule: 'required', errorMessage: 'El nombre es obligatorio'},
                        {rule: 'minLength', value: 3, errorMessage: "Minimo 3 caracteres"}
                    ])
                    .onSuccess((event) => {
                        event.target.submit();
                    });


        </script>
    </body>
</html>
