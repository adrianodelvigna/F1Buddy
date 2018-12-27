
package udacity.androidnanodegree.adriano.capstone.fragments.constructorstandings.models;

import com.squareup.moshi.Json;

public class Constructor {

    @Json(name = "constructorId")
    public String constructorId;
    @Json(name = "url")
    public String url;
    @Json(name = "name")
    public String name;
    @Json(name = "nationality")
    public String nationality;
}
