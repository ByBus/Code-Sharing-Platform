package platform.buisness;

public interface Mapper<T, U> {
    U mapToDTO(T objFrom);

    T mapToEntity(U objFrom);
}