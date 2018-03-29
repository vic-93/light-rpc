package org.rpc.serialzation;

/**
 * 序列化及接口<br>
 *
 * @author andy
 * @version V1.0
 * @date 18/3/18 上午1:49
 */
public interface ISerializer {

    /**
     * 序列化
     *
     * @param object 序列化对象
     * @param <T> 泛型
     * @return  byte[]
     */
    <T> byte[] serialize(T object);

    /**
     * 反序列化
     *
     * @param data 序列化字节数字
     * @param cls   类类型
     * @param <T>   泛型
     * @return  T
     */
    <T> T deserialize(byte[] data, Class<T> cls);

}
