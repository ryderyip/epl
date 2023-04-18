<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/css/style.css" rel="stylesheet">
        <title>Register Page</title>
    </head>
    <body>
        <main>
            <div class="container">
                <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                            <div class="card mb-3">
                                <div class="card-body">
                                <div class="pt-4 pb-2">
                                    <h1 class="card-title text-center pb-0 fs-4">IVE Booking</h1>
                                    <p class="text-center small">Fill in the information to register</p>
                                </div>
                                
                                <form class="row g-3 needs-validation" method="POST" action="#">
                
                                    <div class="col-12">
                                    <label for="username" class="form-label">Username</label>
                                    <div class="input-group has-validation">
                                        <input type="text" name="username" class="form-control" id="username" required>
                                        <div class="invalid-feedback">Please enter your username.</div>
                                    </div>
                                    </div>
                
                                    <div class="col-12">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" name="password" class="form-control" id="password" required>
                                    <div class="invalid-feedback">Please enter your password!</div>
                                    </div>
                                    
                                    <div class="col-12">
                                    <label for="name" class="form-label">Name</label>
                                    <input type="text" name="name" class="form-control" id="name" required>
                                    <div class="invalid-feedback">Please enter your name!</div>
                                    </div>
                                    
                                    <div class="col-12">
                                    <label for="phone" class="form-label">Phone</label>
                                    <input type="text" name="phone" class="form-control" id="phone" required>
                                    <div class="invalid-feedback">Please enter your name!</div>
                                    </div>
                                    
                                    <div class="col-12">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" name="email" class="form-control" id="email" required>
                                    <div class="invalid-feedback">Please enter your name!</div>
                                    </div>
        
                                    <div class="col-12">
                                    <button class="btn btn-primary w-100" type="submit">Register</button>
                                    </div>
                                    <div class="col-12">
                                        <p class="small mb-0">Already have account? <a href="login.jsp">Click me Login</a></p>
                                    </div>
                                </form>
                                </div>
                            </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </main>
    </body>
</html>
