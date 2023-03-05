import { useEffect,useState } from "react";
import Server from "./Server";
const Display=()=>{
    let [prodarr,setprodarr]=useState([]);

    useEffect(()=>{
        Server.getAllProduct().then((resp)=>{
            console.log(resp.data);
            setprodarr(resp.data);
        });
    });
    const Render=()=>{
        return prodarr.map((prod)=>{
            return <tr key={prod.id}><td>{prod.id}</td><td>{prod.name}</td><td>{prod.price}</td></tr>
        });
    }
    return(
        <div>
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
                {Render()}
            </table>
        </div>
    )
}
export default Display;