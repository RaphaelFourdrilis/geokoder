title: Geokoder usage
hero: Look for addresses, places, POI, and routes

Introduction
------------

This service allows you to query several different open source services in one place. We aggregate:

- [OpenAddresses][OA]: Holds a lot of addresses over the world.
- [OpenStreetMap][OSM]: Maps the street all around the world.
- [Geonames][GEO]: A database of place names.
- [Who'sOnFirst][WOF]: A phone book, but for places.
- [Polylines][POL]: A service to import geo-data.

Most of (if not all) the merit must go to [pelias][PEL] for this aggregated service,
and to each of these individual services of course. Our server is just a way to easily
aggregate queries and responses.

On top of those, we have an additional service:

- [OpenSourceRoutingMachine][OSRM]: Used to draw routes between points and get distance / time.

And, finally, our server uses [Graphql][GQL] to ease request handling.

Usage
-----

### HTTP endpoints

We keep our API documentation within [Postman Documenter][PMD].
Feel free to browse, it is quite comprehensive!

C# helper classes
-----------------

[OA]: https://openaddresses.io/
[OSM]: https://www.openstreetmap.org/
[GEO]: http://www.geonames.org/
[WOF]: https://www.whosonfirst.org/
[POL]: https://developers.google.com/maps/documentation/utilities/polylinealgorithm
[OSRM]: http://project-osrm.org/
[PEL]: https://github.com/pelias/pelias/
[GQL]: https://graphql.org/
[PMD]: https://documenter.getpostman.com/view/4016557/RWEZTP8U