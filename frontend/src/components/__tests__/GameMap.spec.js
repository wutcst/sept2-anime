import { describe, it, expect } from 'vitest'
import { mount } from '@vue/test-utils'
import GameMap from '../GameMap.vue'

describe('GameMap', () => {
    it('renders map correctly', () => {
        // 模拟传入的属性
        const props = {
            newPlayer: [5, 5],
            load:false,
            loadMsg:"Loading..."
        };

        // 挂载组件
        const wrapper = mount(GameMap, {
            propsData: props,
        });

        // 断言地图元素的数量
        const mapElements = wrapper.findAll('.row img');
        expect(mapElements.length).toBe(81); // 9 x 9 grid

        // 断言玩家位置
        const playerElement = wrapper.find('.row img[src="https://s1.imgcap.xyz/47a8e45d64b1117f4807d23268aabdc1.png"]');
        expect(playerElement.exists()).toBe(true);
        expect(wrapper.vm.player).toEqual([5,5]);

        // 断言加载状态
        expect(wrapper.props('load')).toBe(false);
        expect(wrapper.props('loadMsg')).toBe('Loading...');
    });

    it('handles player movement correctly', async () => {
        const wrapper = mount(GameMap);

        // 触发方向键事件
        await wrapper.trigger('keydown', { keyCode: 38 }); // 上箭头键

        // 触发方向键事件
        await wrapper.trigger('keydown', { keyCode: 40 }); // 下箭头键

        // 断言玩家位置改变
        expect(wrapper.vm.player).toEqual([5,5]);
    });
})
