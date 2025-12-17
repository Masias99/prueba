<%-- 
    Document   : login
    Created on : 10 dic. 2025, 19:50:16
    Author     : christianruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/daisyui@5" rel="stylesheet" type="text/css" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
        <title>JSP Page</title>
    </head>
    <body>
       <div class="hero min-h-screen bg-base-200">
        <div class="hero-content flex-col lg:flex-row-reverse">
            <div class="card shrink-0 w-full max-w-sm shadow-2xl bg-base-100">
                <div class="card-body">
                    <h2 class="text-center text-2xl font-bold mb-4">Iniciar Sesión</h2>
                    
                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Usuario</span>
                        </label>
                        <input type="text" id="usuario" placeholder="Ej: admin" class="input input-bordered" required />
                    </div>

                    <div class="form-control">
                        <label class="label">
                            <span class="label-text">Contraseña</span>
                        </label>
                        <input type="password" id="password" placeholder="**" class="input input-bordered" required />
                    </div>

                    <div class="form-control mt-6">
                        <button onclick="validarAcceso()" class="btn btn-primary">Ingresar</button>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    </body>
</html>
