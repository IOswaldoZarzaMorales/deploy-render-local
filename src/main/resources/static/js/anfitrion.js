//remote
const lugarForm = document.querySelector(".form-anfitrion");
lugarForm.addEventListener('submit', async () => {
const nombreLugar = document.getElementById("inputNombre").value;
const tipo_espacio = document.getElementById("inputEspacio").value;
const capacidad = document.getElementById("inputCapacidad").value;
const calle = document.getElementById("inputCalle").value;
const numInt = document.getElementById("inputNumeroInt").value;
const numExt = document.getElementById("inputNumeroExt").value;
const alcaldia = document.getElementById("inputAlcaldia").value;
const estado = document.getElementById("inputEstado").value;
const codigoPostal = document.getElementById("inputCodigo").value;
const precio = document.getElementById("inputPrecio").value;


const lugar = {
nombre: nombreLugar,
espacio: tipo_espacio,
capacidad: capacidad,
calle: calle,
no_int: numInt,
no_ext: numExt,
alcaldia: alcaldia,
estado: estado,
codigo_postal: codigoPostal,
precio: precio
} 

const url = 'https://loklapp.onrender.com/admin/lugares';
// prueba'http://localhost:8080/admin/lugares';


try{
  const response = await fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(lugar)
  });

 /*  if (!response.ok) {
    throw new Error('Error al registrar el lugar');
  }  */
  const data = await response.json();
  console.log(data);
  return alert('¡Lugar creado con éxito!'); 
  //window.location.href = './miespacio.html';
}catch(error) {
  console.error('Error al crear el lugar:', error);
 
} 
  })