#language: es

Característica: Como usuario quiero validar la selección de un checkbox mediante un mensaje esperado

  Escenario: marcar un checkbox validar su selección
    Dado que ingreso a la pagina Selenium Easy y navego hasta el formualario Input Forms/Checkbox Demo
    Cuando marco el checkbox
    Entonces valido el mensaje en pantalla Success - Check box is checked
