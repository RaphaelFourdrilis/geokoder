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

There is only one endpoint for all services: `/graphql`. A generic [Graphql][GQL] query looks
like this:

```http
POST https://sh-ov-cmon-geo2/graphql
Content-Type: application/json

{
    "query": "name(arg1, arg2, ...) { filter1, filter2 }"
}
```

Several things to pay attention to here:

- `name` is the name of the service you want to query
- `args` are the arguments the service takes as input
- `filters` are pieces of the response you want to get

For example, if you wanted to `search` for an address and only get the name and the country
instead of all possible information about the result, you would need to send this query:

```http
POST https://sh-ov-cmon-geo2/graphql
Content-Type: application/json

{
    "query": "search(14 rue Gerty Archimede) { name, country }"
}
```

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