USE labv_tp_gestioneducativa_spring;

INSERT into tipoUsuarios SET idTipoUsuario=1, descripcion='Alumno';
INSERT into tipoUsuarios SET idTipoUsuario=2, descripcion='Profesor';
INSERT into tipoUsuarios SET idTipoUsuario=3, descripcion='Administrador';

INSERT into usuario SET idUsuario=1, nombre='admin', apellido='admin', dni='0000000001', calleNombre='nombreCalle', calleAltura='000', fechaNac=STR_TO_DATE('01/12/1990','%d/%m/%Y') , nroTelefono='00000', mail='admin@admin.com', clave='admin', idTipoUsuario=3, habilitado=1 ;
INSERT into usuario SET idUsuario=2, nombre='utn1', apellido='frgp1', dni='3333333331', calleNombre='nombreCalle', calleAltura='000', fechaNac=STR_TO_DATE('01/12/1990','%d/%m/%Y') , nroTelefono='33333', mail='utn1frgp1@gmail.com', clave='utn123', idTipoUsuario=3, habilitado=1 ;
INSERT into usuario SET idUsuario=3, nombre='utn2', apellido='frgp2', dni='3333333332', calleNombre='nombreCalle', calleAltura='000', fechaNac=STR_TO_DATE('01/12/1990','%d/%m/%Y') , nroTelefono='33333', mail='utn2frgp2@gmail.com', clave='utn123', idTipoUsuario=3, habilitado=1 ;
INSERT into usuario SET idUsuario=4, nombre='utn3', apellido='frgp3', dni='3333333333', calleNombre='nombreCalle', calleAltura='000', fechaNac=STR_TO_DATE('01/12/1990','%d/%m/%Y') , nroTelefono='33333', mail='utn3frgp3@gmail.com', clave='utn123', idTipoUsuario=3, habilitado=1 ;
INSERT into usuario SET idUsuario=5, nombre='Tamara', apellido='A. Profe', dni='221', calleNombre='calle profe ', calleAltura='222', fechaNac=STR_TO_DATE('01/01/2000','%d/%m/%Y') , nroTelefono='22222', mail='profe@gmail.com1', clave='utn123', idTipoUsuario=2, habilitado=1 ;
INSERT into usuario SET idUsuario=6, nombre='Ayelén', apellido='Flores', dni='222', calleNombre='calle profe ', calleAltura='222', fechaNac=STR_TO_DATE('01/01/2000','%d/%m/%Y') , nroTelefono='22222', mail='profe@gmail.com2', clave='utn123', idTipoUsuario=2, habilitado=1 ;
INSERT into usuario SET idUsuario=7, nombre='Silvia', apellido='Malloti', dni='223', calleNombre='calle profe ', calleAltura='222', fechaNac=STR_TO_DATE('01/01/2000','%d/%m/%Y') , nroTelefono='22222', mail='profe@gmail.com3', clave='utn123', idTipoUsuario=2, habilitado=1 ;
INSERT into usuario SET idUsuario=8, nombre='Clara', apellido='Del Valle', dni='11111', calleNombre='calle alumno', calleAltura='111', fechaNac=STR_TO_DATE('01/12/2000','%d/%m/%Y') , nroTelefono='11111', mail='alumno@gmail.com1', clave='utn123', idTipoUsuario=1, habilitado=1 ;
INSERT into usuario SET idUsuario=9, nombre='Jaime', apellido='Trueba', dni='11112', calleNombre='calle alumno', calleAltura='111', fechaNac=STR_TO_DATE('01/12/2000','%d/%m/%Y') , nroTelefono='11111', mail='alumno@gmail.com2', clave='utn123', idTipoUsuario=1, habilitado=1 ;
INSERT into usuario SET idUsuario=10, nombre='Alba', apellido='De Satigny', dni='11113', calleNombre='calle alumno', calleAltura='111', fechaNac=STR_TO_DATE('01/12/2000','%d/%m/%Y') , nroTelefono='11111', mail='alumno@gmail.com3', clave='utn123', idTipoUsuario=1, habilitado=1 ;
INSERT into usuario SET idUsuario=11, nombre='Pedro', apellido='Tercero García', dni='11114', calleNombre='calle alumno', calleAltura='111', fechaNac=STR_TO_DATE('01/12/2000','%d/%m/%Y') , nroTelefono='11111', mail='alumno@gmail.com4', clave='utn123', idTipoUsuario=1, habilitado=1 ;

INSERT into TipoPeriodo SET idPeriodo=1, descripcion='1° Cuatrimestre' ;
INSERT into TipoPeriodo SET idPeriodo=2, descripcion='2° Cuatrimestre' ;

INSERT into curso SET idCurso=1, nombreCurso='Programación', anio=2019, idPeriodo=1, dniProfesor='221' ;
INSERT into curso SET idCurso=2, nombreCurso='Matemáticas', anio=2019, idPeriodo=1, dniProfesor='222' ;
INSERT into curso SET idCurso=3, nombreCurso='Inglés', anio=2019, idPeriodo=1, dniProfesor='223' ;
INSERT into curso SET idCurso=4, nombreCurso='Inglés Avanzado', anio=2019, idPeriodo=2, dniProfesor='223' ;

INSERT into TipoExamen SET idTipoExamen=1, descripcion='Examen Parcial' ;
INSERT into TipoExamen SET idTipoExamen=2, descripcion='Recuperatorio' ;
INSERT into TipoExamen SET idTipoExamen=3, descripcion='TP' ;
INSERT into TipoExamen SET idTipoExamen=4, descripcion='TP Integrador' ;
INSERT into TipoExamen SET idTipoExamen=5, descripcion='Examen Final' ;


INSERT into cursosCalificaciones SET idCursoCalif=1, idCurso=1, dniAlumno='11111', idTipoExamen=1, nota=10, fechaCalif=STR_TO_DATE('01/04/2019','%d/%m/%Y') ;
INSERT into cursosCalificaciones SET idCursoCalif=2, idCurso=1, dniAlumno='11112', idTipoExamen=1, nota=8, fechaCalif=STR_TO_DATE('01/04/2019','%d/%m/%Y') ;
INSERT into cursosCalificaciones SET idCursoCalif=3, idCurso=1, dniAlumno='11113', idTipoExamen=1, nota=9, fechaCalif=STR_TO_DATE('01/04/2019','%d/%m/%Y') ;
INSERT into cursosCalificaciones SET idCursoCalif=4, idCurso=1, dniAlumno='11114', idTipoExamen=1, nota=8, fechaCalif=STR_TO_DATE('01/04/2019','%d/%m/%Y') ;
INSERT into cursosCalificaciones SET idCursoCalif=5, idCurso=2, dniAlumno='11111', idTipoExamen=1, nota=8, fechaCalif=STR_TO_DATE('21/04/2019','%d/%m/%Y') ;
INSERT into cursosCalificaciones SET idCursoCalif=6, idCurso=2, dniAlumno='11112', idTipoExamen=1, nota=8, fechaCalif=STR_TO_DATE('21/04/2019','%d/%m/%Y') ;
INSERT into cursosCalificaciones SET idCursoCalif=7, idCurso=2, dniAlumno='11113', idTipoExamen=1, nota=8, fechaCalif=STR_TO_DATE('21/04/2019','%d/%m/%Y') ;
INSERT into cursosCalificaciones SET idCursoCalif=8, idCurso=3, dniAlumno='11111', idTipoExamen=1, nota=9, fechaCalif=STR_TO_DATE('01/05/2019','%d/%m/%Y') ;
INSERT into cursosCalificaciones SET idCursoCalif=9, idCurso=4, dniAlumno='11112', idTipoExamen=1, nota=8, fechaCalif=STR_TO_DATE('01/05/2019','%d/%m/%Y') ;
INSERT into cursosCalificaciones SET idCursoCalif=10, idCurso=4, dniAlumno='11113', idTipoExamen=1, nota=8, fechaCalif=STR_TO_DATE('01/05/2019','%d/%m/%Y') ;


