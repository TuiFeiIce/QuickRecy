# QuickRecy
RecyclerView快速开发

        quickAdapter = new QuickAdapter<String>(Contracts.typeList) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.recy_content;
            }

            @Override
            public void convert(VH holder, String data, int position) {
                TextView tv = holder.getView(R.id.tv_item_name);
                tv.setText(Contracts.typeList.get(position));
            }
        };
        recyclerview.setAdapter(quickAdapter);
        
简单Adapter无需调整，快速开发

还有自定义头部底部

![Quickrecy1](https://user-images.githubusercontent.com/34259093/115951839-7f165b80-a515-11eb-8f01-12192f32aaea.jpg)
![Quickrecy2](https://user-images.githubusercontent.com/34259093/115951841-80e01f00-a515-11eb-881c-bd348908ff3d.jpg)
![Quickrecy3](https://user-images.githubusercontent.com/34259093/115951844-80e01f00-a515-11eb-9be2-f3dde38fef63.jpg)
