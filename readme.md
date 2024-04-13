gameserverdemo.database.windows.net

<br>demoadmin

<br>Java1234


<h2>Unity Call Webservice:
</h2>
```csharp
using UnityEngine;
using UnityEngine.Networking;
using System.Collections;

public class MyAPI : MonoBehaviour
{
    private const string URL = "https://www.AlbanyIEEEApi.com";

    public void GenerateRequest()
    {
        StartCoroutine(ProcessRequest(URL));
    }

    private IEnumerator ProcessRequest(string uri)
    {
        using (UnityWebRequest request = UnityWebRequest.Get(uri))
        {
            yield return request.SendWebRequest();

            if (request.isNetworkError)
            {
                Debug.Log(request.error);
            }
            else
            {
                Debug.Log(request.downloadHandler.text);
            }
        }
    }
}
```     

