# wine-management-api
Welcome to the Wine API! This API empowers you to manage your wine collection, associating each wine with specific boxes, grapes used in production, and regions of origin. Below is a comprehensive guide to the available endpoints and their functionalities.

# API Reference

Get All Wines
--------------

Request
-------
GET /wines

Add a Wine
----------

Request
-------
POST /wines

Parameters
----------
| Parameter     | Type       | Description                           |
| :------------ | :--------- | :------------------------------------ |
| `title`       | `string`   | **Required**. Title of the wine.       |
| `type`        | `string`   | **Required**. Type of the wine.        |
| `year`        | `integer`  | **Required**. Year the wine was made.  |
| `regionName`  | `string`   | **Required**. Name of the wine region. |
| `grapeTitles` | `array`    | **Required**. List of grape titles.    |
| `boxTitle`    | `string`   | **Required**. Title of the wine box.   |

Update a Wine
-------------

Request
-------
PUT /wines/{id}

Parameters
----------
| Parameter | Type       | Description                    |
| :-------- | :--------- | :----------------------------- |
| `id`      | `integer`  | **Required**. ID of the wine.   |

----------
| Parameter     | Type       | Description                           |
| :------------ | :--------- | :------------------------------------ |
| `title`       | `string`   | **Required**. Title of the wine.       |
| `type`        | `string`   | **Required**. Type of the wine.        |
| `year`        | `integer`  | **Required**. Year the wine was made.  |
| `regionName`  | `string`   | **Required**. Name of the wine region. |
| `grapeTitles` | `array`    | **Required**. List of grape titles.    |
| `boxTitle`    | `string`   | **Required**. Title of the wine box.   |

Delete a Wine
-------------

Request
-------
DELETE /wines/{id}

Parameters
----------
| Parameter | Type       | Description                    |
| :-------- | :--------- | :----------------------------- |
| `id`      | `integer`  | **Required**. ID of the wine.   |

Get All Wines by Region
------------------------

Request
-------
GET /wines/region/{region}

Parameters
----------
| Parameter | Type       | Description                         |
| :-------- | :--------- | :---------------------------------- |
| `region`  | `string`   | **Required**. Name of the region.    |

Get All Wines by Country
-------------------------

Request
-------
GET /wines/country/{country}

Parameters
----------
| Parameter | Type       | Description                         |
| :-------- | :--------- | :---------------------------------- |
| `country` | `string`   | **Required**. Name of the country.   |

Get All Regions
---------------

Request
-------
GET /regions

Create a Region
---------------

Request
-------
POST /regions

Parameters
----------
| Parameter    | Type       | Description                           |
| :----------- | :--------- | :------------------------------------ |
| `name`       | `string`   | **Required**. Name of the region.      |
| `country`    | `string`   | **Required**. Country of the region.   |
| `description`| `string`   | **Required**. Description of the region.|

Get Region by Name
------------------

Request
-------
GET /regions/name/{name}

Parameters
----------
| Parameter | Type       | Description                         |
| :-------- | :--------- | :---------------------------------- |
| `name`    | `string`   | **Required**. Name of the region.    |

Delete Region by ID
-------------------

Request
-------
DELETE /regions/{id}

Parameters
----------
| Parameter | Type       | Description                    |
| :-------- | :--------- | :----------------------------- |
| `id`      | `integer`  | **Required**. ID of the region. |

Get All Grapes
--------------

Request
-------
GET /grapes

Create a Grape
--------------

Request
-------
POST /grapes

Parameters
----------
| Parameter   | Type       | Description                         |
| :---------- | :--------- | :---------------------------------- |
| `title`     | `string`   | **Required**. Title of the grape.    |
| `type`      | `string`   | **Required**. Type of the grape.     |
| `description`| `string`  | **Required**. Description of the grape. |

Delete Grape by ID
------------------

Request
-------
DELETE /grapes/{id}

Parameters
----------
| Parameter | Type       | Description                    |
| :-------- | :--------- | :----------------------------- |
| `id`      | `integer`  | **Required**. ID of the grape.  |

Get All Boxes
-------------

Request
-------
GET /boxes

Create a Box
------------

Request
-------
POST /boxes

Parameters
----------
| Parameter | Type       | Description                    |
| :-------- | :--------- | :----------------------------- |
| `name`    | `string`   | **Required**. Name of the box.  |

Get Box by Wine ID
------------------

Request
-------
GET /boxes/{wineId}

Parameters
----------
| Parameter | Type       | Description                    |
| :-------- | :--------- | :----------------------------- |
| `wineId`  | `integer`  | **Required**. ID of the wine.   |

Delete Box by ID
-----------------

Request
-------
DELETE /boxes/{id}

Parameters
----------
| Parameter | Type       | Description                    |
| :-------- | :--------- | :----------------------------- |
| `id`      | `integer`  | **Required**. ID of the box.    |
