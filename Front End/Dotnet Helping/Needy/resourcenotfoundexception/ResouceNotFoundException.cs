using System;

// namespace MyApp.CustomExceptions
namespace BOL;
    public class ResourceNotFoundException : Exception
    {
        public ResourceNotFoundException(string message) : base(message)
        {
        }
    }


// public void GetResource(int resourceId)
// {
//     // ... code to fetch resource with the given ID

//     if (resource == null)
//     {
//         throw new ResourceNotFoundException($"Resource with ID {resourceId} was not found.");
//     }
// }
