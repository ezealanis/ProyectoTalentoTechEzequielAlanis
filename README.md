[README.md](https://github.com/user-attachments/files/23107083/README.md)
Bienvenido a la Tienda

Guía de uso para el usuario

Menú principal:
Se mostrará un menú con 7 opciones, el cual se repetirá hasta que el usuario seleccione la opción 7 - Salir.
1.1. El usuario deberá ingresar un valor válido, que no contenga letras ni caracteres especiales (de lo contrario se ejecutará una excepción).
1.2. El usuario deberá ingresar un valor dentro del rango de 1 a 7 (en caso contrario se mostrará un mensaje de error).

Opción 1 - Alta de productos:
Permite dar de alta un producto por vez.
2.1. El programa solicitará el nombre, precio y cantidad de stock del producto.
2.2. Antes de guardar, al nombre se le dará formato (por ejemplo: ingresa → cAfE, guarda → Café).
2.3. Luego, el nombre pasará por una serie de validaciones:
- No puede estar vacío.
- No puede contener números.
- No puede estar duplicado.
2.4. Si supera todas las validaciones, se permitirá cargar el precio y el stock.

Opción 2 - Listar productos:
Muestra todos los productos cargados.
3.1. Si la lista se encuentra vacía, se mostrará el mensaje “Lista vacía”.
3.2. Se mostrarán los productos con su ID (posición en la lista + 1), nombre, precio y stock disponible.
3.3. Si el producto no posee stock, se mostrará la leyenda “❌ Stock no disponible”.

Opción 3 - Buscar y actualizar productos:
Permite buscar un producto y modificar sus datos.
4.1. Al ingresar, se mostrará un submenú con dos opciones:
- 4.1.1. Buscar por nombre de producto.
- 4.1.2. Buscar por ID de producto (trae un único producto).
4.2. Si el usuario busca por nombre:
- 4.2.1. Si se encuentran varios productos con nombres similares, se mostrarán y se pedirá seleccionar el ID del producto a actualizar.
- 4.2.2. Si se encuentra una sola coincidencia, se mostrará directamente.
- En ambos casos, el programa consultará si el usuario desea continuar con la actualización.
4.3. Si el usuario confirma:
- 4.3.1. Podrá ingresar nuevos datos o conservar los actuales presionando Enter.
- 4.3.2. Si ingresa un dato erróneo, se conservará el valor anterior.
4.4. Al finalizar, se mostrará el mensaje “✅ Producto actualizado correctamente.”

Opción 4 - Eliminar productos:
Sigue el mismo procedimiento que la opción de actualización, pero en este caso el producto será eliminado de la lista.

Opción 5 - Realizar pedidos:
Permite crear un pedido con los productos disponibles.
6.1. Se mostrará la lista de productos, y el programa pedirá el ID del producto que se desea agregar al pedido.
- 6.1.1. Los productos con la leyenda “❌ Stock no disponible” no podrán agregarse.
6.2. El programa solicitará la cantidad a agregar.
- 6.2.1. Si el ingreso no es numérico, se mostrará un mensaje de error.
6.3. Después de cada carga, el sistema preguntará si desea agregar otro producto.
6.4. El proceso continuará hasta que el usuario decida no agregar más productos.
6.5. Al finalizar, se mostrará el mensaje “✅ Pedido cargado con éxito”.

Opción 6 - Listar pedidos:
Muestra todos los pedidos cargados.
7.1. Para cada pedido se mostrará:
- Nombre del producto.
- Precio parcial.
- Total parcial por producto.
- Total general del pedido (suma de todos los productos).

Opción 7 - Salir:
Finaliza la ejecución del programa y muestra el mensaje:
“¡Gracias por utilizar el sistema, hasta luego!”
