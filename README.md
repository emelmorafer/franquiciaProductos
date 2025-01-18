Repositorio de nuestro proyecto: https://github.com/emelmorafer/franquiciaProductos/tree/master

Para probar nuestra Api Rest debemos correrla en Local y luego probar cada uno de los siguientes endpoint y debemos obtener los resultados allí mostrados. Tambien podremos probar los endpoints con la version de nuestra aplicacion que esta desplegada en render.com

Version Local:
[servidor] = http://localhost:8080

Version render.com:
[servidor] = https://franquiciaproductos.onrender.com

_______________________________________________________________________________________________
REQUEST:
POST: [servidor]/adminFranquicia/franquicia?nombre=franquiciatest

ESPECTED RESULT:
{
    "id": 3,
    "nombre": "franquiciatest"
}

_______________________________________________________________________________________________
REQUEST:
PUT:  [servidor]/adminFranquicia/franquicia/updatename?id=1&nombre=MacDonals2

ESPECTED RESULT:
{
    "id": 1,
    "nombre": "MacDonals2"
}

_______________________________________________________________________________________________
REQUEST:
GET:  [servidor]/adminFranquicia/franquicia/productowithmMorestockbysucursal?id=1

ESPECTED RESULT:
[
    {
        "nombreProducto": "hamburguesa1",
        "nombreSucursal": "MacDonals Barranquilla"
    },
    {
        "nombreProducto": "hamburguesa2",
        "nombreSucursal": "MacDonals Medellin"
    }
]

_______________________________________________________________________________________________
REQUEST:
POST: [servidor]/adminSucursal/sucursal?nombre=franquiciatest&franquiciaId=1

ESPECTED RESULT:
{
    "id": 5,
    "nombre": "franquiciatest",
    "franquicia_id": 1
}

_______________________________________________________________________________________________
REQUEST:
PUT:  [servidor]/adminSucursal/sucursal/updatename?id=1&nombre=MacDonals Barranquilla2

ESPECTED RESULT:
{
    "id": 1,
    "nombre": "MacDonals Barranquilla2",
    "franquicia_id": 1
}

_______________________________________________________________________________________________
REQUEST:
POST: [servidor]/adminProducto/producto?nombre=productotest&stock=31&sucursalId=1

ESPECTED RESULT:
{
    "id": 9,
    "nombre": "productotest",
    "stock": 31,
    "sucursal_id": 1
}

_______________________________________________________________________________________________
REQUEST:
PUT:  [servidor]/adminProducto/producto/updatestock?id=1&stock=53

ESPECTED RESULT:
{
    "id": 1,
    "nombre": "hamburguesa1",
    "stock": 53,
    "sucursal_id": 1
}

_______________________________________________________________________________________________
REQUEST:
PUT:  [servidor]/adminProducto/producto/updatename?id=1&nombre=hamburguesa11

ESPECTED RESULT:
{
    "id": 1,
    "nombre": "hamburguesa11",
    "stock": 53,
    "sucursal_id": 1
}

_______________________________________________________________________________________________
REQUEST:
DELETE:  [servidor]/adminProducto/producto/8

ESPECTED RESULT:
El producto fue eliminado exitosamente
