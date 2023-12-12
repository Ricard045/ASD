document.addEventListener("DOMContentLoaded", function () {
  const botonesAgregar = document.querySelectorAll(".agregar-al-carrito");
  const carrito = document.querySelector(".carrito-lista");
  const abrirCarrito = document.getElementById("abrir-carrito");
  const carritoContent = document.querySelector(".carrito-content");
  const vaciarCarrito = document.getElementById("vaciar-carrito");

  function actualizarCarrito() {
    carrito.innerHTML = "";
    const carritoGuardado = JSON.parse(localStorage.getItem("carrito")) || [];
    carritoGuardado.forEach((producto, index) => {
      const li = document.createElement("li");
      li.innerHTML = `${producto} <button class="eliminar-producto" data-index="${index}">Eliminar</button>`;
      carrito.appendChild(li);
    });
  }

  // Agregar producto al carrito
botonesAgregar.forEach((boton) => {
  boton.addEventListener("click", (e) => {
    const productoId = e.target.getAttribute("data-id");
    let producto;

    // Asigna el nombre del producto según su ID
    if (productoId === "1") {
      producto = "Leopard";
    } else if (productoId === "2") {
      producto = "kilo";
    } else if (productoId === "3") {
      producto = "masa";
      } else if (productoId === "4") {
      producto = "soul";
      } else if (productoId === "5") {
      producto = "venon";
      } else if (productoId === "6") {
      producto = "graviti";
      } else if (productoId === "7") {
      producto = "control";
      } else if (productoId === "8") {
      producto = "buddha";
    } else {
      producto = "Producto Desconocido";
    }

    // Guardar el carrito en localStorage
    const carritoActual = JSON.parse(localStorage.getItem("carrito")) || [];
    carritoActual.push(producto);
    localStorage.setItem("carrito", JSON.stringify(carritoActual));

    actualizarCarrito();
  });
});

  // Eliminar productos del carrito
  carrito.addEventListener("click", (e) => {
    if (e.target.classList.contains("eliminar-producto")) {
      const index = e.target.getAttribute("data-index");
      const carritoActual = JSON.parse(localStorage.getItem("carrito")) || [];
      carritoActual.splice(index, 1);
      localStorage.setItem("carrito", JSON.stringify(carritoActual));

      actualizarCarrito();
    }
  });

  // Mostrar u ocultar el carrito desplegable
  abrirCarrito.addEventListener("click", () => {
    carritoContent.classList.toggle("mostrar");
  });

  // Vaciar el carrito
  vaciarCarrito.addEventListener("click", () => {
    localStorage.removeItem("carrito");
    actualizarCarrito();
  });

  // Cargar productos desde el almacenamiento local al cargar la página
  actualizarCarrito();
});

