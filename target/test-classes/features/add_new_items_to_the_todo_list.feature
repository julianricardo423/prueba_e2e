@cucumber
@adding
Feature: Automation Exercise - Contact Us

  Scenario: Enviar mensaje en opción contact us y volver al home page
    Given Usuario abre el navegador
    Then Usuario navega a la url y valida que el titulo sea visible
    And Usuario da clic en el botón Contact us
    When Usuario Llena los campos obligatorios Name, Email, Subject, Message
    And Realiza la carga de un archivo 'Upload File'
    And Envía el formulario y aceptar las alertas del navegador
    Then Validar el mensaje de éxito 'Success! Your details have been submitted successfully.'
    And Regresa al home

