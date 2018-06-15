package com.mdx.mybatis.utils;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created on 2017/10/9.
 */
public final class CollectorUtils {

    public static <T, K, V> Collector<T, ?, Map<K, V>> toMap(Function<T, K> f1, Function<T, V> f2) {
        return new ToMapCollector<T, K, V>(f1, f2);
    }

    public static class ToMapCollector<T, K, V> implements Collector<T, Map<K, V>, Map<K, V>> {

        private Function<? super T, ? extends K> keyMapper;

        private Function<? super T, ? extends V> valueMapper;

        public ToMapCollector(Function<? super T, ? extends K> keyMapper,
                               Function<? super T, ? extends V> valueMapper) {
            super();
            this.keyMapper = keyMapper;
            this.valueMapper = valueMapper;
        }

        @Override
        public BiConsumer<Map<K, V>, T> accumulator() {
            return (map, element) -> map.put(keyMapper.apply(element), valueMapper.apply(element));
        }

        @Override
        public Supplier<Map<K, V>> supplier() {
            return HashMap::new;
        }

        @Override
        public BinaryOperator<Map<K, V>> combiner() {
            return null;
        }

        @Override
        public Function<Map<K, V>, Map<K, V>> finisher() {
            return null;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
        }
    }

    private CollectorUtils() {
        // Utility class
    }
}
