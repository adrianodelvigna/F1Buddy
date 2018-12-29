package udacity.androidnanodegree.adriano.capstone.common.webapi;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;

import java.io.IOException;

import retrofit2.Call;
import udacity.androidnanodegree.adriano.capstone.common.Resource;

public class NetworkAsyncTask<T>
        extends AsyncTask<Call<T>, Void, ApiResponse<T>> {

    private final MutableLiveData<Resource<T>> resourceLiveData = new MutableLiveData<>();
    private final MutableLiveData<ApiResponse<T>> apiResponseLiveData = new MutableLiveData<>();

    @Override
    @MainThread
    protected void onPostExecute(ApiResponse<T> apiResponse) {
        apiResponseLiveData.postValue(apiResponse);

        if (apiResponse == null) {
            resourceLiveData.postValue(Resource.error("apiResponse is null", null));
        } else if (apiResponse.isSuccessful()) {
            resourceLiveData.postValue(Resource.success(apiResponse.body));
        } else {
            resourceLiveData.postValue(Resource.error(apiResponse.errorMessage, null));
        }
    }

    @Override
    @WorkerThread
    protected ApiResponse<T> doInBackground(Call<T>... calls) {
        for (Call<T> call : calls) {
            try {
                return new ApiResponse<>(call.execute());
            } catch (IOException e) {
                return new ApiResponse<>(e);
            }
        }
        return null;
    }

    public LiveData<Resource<T>> getResourceLiveData() {
        return resourceLiveData;
    }

    public LiveData<ApiResponse<T>> getApiResponseLiveData() {
        return apiResponseLiveData;
    }
}
