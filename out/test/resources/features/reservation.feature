#language: es

Característica: As a user I want to validate the reservation of a project

  Esquema del escenario: Test of successful reservation of an exclusive project
    Dado que ingreso a la pagina 'https://sobreplanos-staging.herokuapp.com/'
    Y selecciono Conoce proyectos exclusivos en la ciudad '<Ciudad>'
    Y selecciono un apartamento de '<Habitaciones>' habitaciones  el proyecto '<Proyecto>'
    Cuando reservo el apartamento por 72 horas
    Y diligencio el fomulario de reserva
      | nombre            | documento  | correo                  | Pais     | telefono   |
      | Sebastian Galeano | 1152784147 | sebastiansgm1@gmail.com | Colombia | 3217522706 |
    Entonces se enviara el formulario de reserva correctamente

    Ejemplos:
      | Ciudad               | Proyecto    | Habitaciones |
      | Bogotá y alrededores | Urban Chicó | 2            |